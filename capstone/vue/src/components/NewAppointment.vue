<template>
  <div class="container">
    <div class="main">
      <h1 class="appointment-header">
        {{ this.$store.state.doctor.fullName }}'s Availability:
      </h1>

      <div class="calendar">
        <div v-show="date == null">
          <h5>Please select a date:</h5>
        </div>

        <v-date-picker
          v-model="date"
          :min-date="new Date()"
          :disabled-dates="{ weekdays: this.$store.state.disabledDates }"
          @dayclick="setDaySchedule"
        />
      </div>

      <div class="time-slots">
        <div v-show="date != null">
          <h5>Please select a date and time:</h5>
        </div>
        <b-button
          variant="primary"
          class="buttons"
          v-for="n in this.$store.state.dayScheduleArray"
          v-bind:key="n"
          v-on:click="displayAppointmentTime(n)"
          v-model="selectedHour"
          >{{ n }}:00</b-button
        >
        <b-button
          variant="primary"
          class="buttons"
          v-for="n in this.$store.state.eveningScheduleArray"
          v-bind:key="n"
          v-on:click="displayAppointmentTime(n)"
          >{{ n }}:00</b-button
        >
        <div v-show="showConfirm">
          <label for="reason"
            >Please enter your reason for the appointment:</label
          >
          <textarea id="reason" v-model="reason"></textarea>
        </div>
        <div v-show="showConfirm">
          <p>Please confirm the appointment time:</p>
          <p>
            {{
              this.$store.state.activeDate === null
                ? ""
                : this.$store.state.activeConfirmation
            }}
          </p>
          <div>
            <b-form-checkbox
              v-model="value"
      :options="options"
      :state="state"
      name="checkbox-validation"
              @change="updateSchedule"
            >The appointment time above is correct
        </b-form-checkbox>
<br>
            <b-button v-on:click="submitNewAppt" variant="outline-primary"
              >Request appointment</b-button
            >
                

          </div>
          <br /><br />
        </div>
      </div>
    </div>
    
  </div>
</template>

<script>
import AgendaService from "@/services/AgendaService";
import AppointmentService from "@/services/AppointmentService";
import DoctorService from "@/services/DoctorService";
import MessageService from "@/services/MessageService";

export default {
  created() {
    this.findDisabledDates();
    this.getAgenda();
    this.getDoctorInformation();
  },
  name: "appointment-page",
  props: ["doctorID", "agenda"],
  components: {},
  data() {
    return {
       value: [],
      drID: parseInt(this.doctorID),
      storedAgenda: this.agenda,
      date: null,
      selectedDaySchedule: {
        day: "",
        hours: [],
      },
      selectedHour: 0,
      stringDate: "",
      reason: "",
      showConfirm: false,
      newAgenda: {
        agendaId: 0,
        doctorId: 0,
        mon: "",
        tue: "",
        wen: "",
        thur: "",
        fri: "",
        sat: "",
        sun: "",
      },
      appointment: {
        id: 0,
        patientId: 0,
        doctorId: 0,
        agendaId: 0,
        startTime: "",
        endTime: "",
        date: "",
        status: "",
        reason: "",
      },
    };
  },
  methods: {
    createUpdatedAppointment(dayCode) {
      switch (dayCode) {
        case 2: //mon
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sat = this.storedAgenda.sat;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 3: //tue
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sat = this.storedAgenda.sat;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 4: //wen
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sat = this.storedAgenda.sat;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 5: //thur
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sat = this.storedAgenda.sat;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 6: //fri
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.sat = this.storedAgenda.sat;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 7: //sat
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sun = this.storedAgenda.sun;
          break;
        case 1: //sun
          this.newAgenda.mon = this.storedAgenda.mon;
          this.newAgenda.tue = this.storedAgenda.tue;
          this.newAgenda.wen = this.storedAgenda.wen;
          this.newAgenda.thur = this.storedAgenda.thur;
          this.newAgenda.fri = this.storedAgenda.fri;
          this.newAgenda.sat = this.storedAgenda.sat;
          break;
      }
    },
    submitNewAppt() {
      const newAppt = {
        patientId: this.$store.state.user.id,
        doctorId: this.doctorID,
        agendaId: this.agenda.agendaId,
        startTime: this.$store.state.activeStringTimeStart,
        endTime: this.$store.state.activeStringTimeEnd,
        date: this.$store.state.activeStringDate,
        status: "Confirmed",
        reason: this.reason,
      };

      const pendingApptMessage = {
        userId: this.doctorID,
        appointmentId: 0,
        message:
          "Patient " +
          this.$store.state.user.fullName +
          " appointment has been scheduled.",
        read: false,
      };

      const newApptMessageToPatient = {
        userId: this.doctorID,
        appointmentId: 0,
        message:
          "Your appointment with " +
          this.$store.state.doctor.fullName +
          " has been scheduled.",
        read: false,
      };
      AppointmentService.createAppointment(newAppt).then((response) => {
        if (response.status === 201) {
          //todo: chk msg response
          //sending msg to doctor
          this.$store.commit("SET_ACTIVE_APPT", response.data);
          pendingApptMessage.appointmentId = this.$store.state.appointment.id;
          newApptMessageToPatient.appointmentId =
            this.$store.state.appointment.id;
          MessageService.sendMessage(pendingApptMessage);

          pendingApptMessage.userId = this.$store.state.user.id
          MessageService.sendMessage(pendingApptMessage)

          MessageService.sendMessage(newApptMessageToPatient);
          AgendaService.updateAgenda(this.newAgenda);

             alert(
            "Thank you for scheduling an appointment!"
          );
       
         
        }
      });

      this.$router.push(`/user/${this.$store.state.user.id}/appointments/`);
    },
    updateSchedule() {
      const day = this.date.getDay() + 1;

      this.newAgenda.agendaId = this.agenda.agendaId;
      this.newAgenda.doctorId = this.doctorID;

      switch (day) {
        case 2:
          this.newAgenda.mon = this.storedAgenda.mon.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 3:
          this.newAgenda.tue = this.storedAgenda.tue.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 4:
          this.newAgenda.wen = this.storedAgenda.wen.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 5:
          console.log("case 5");
          this.newAgenda.thur = this.storedAgenda.thur.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 6:
          this.newAgenda.fri = this.storedAgenda.fri.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 7:
          this.newAgenda.sat = this.storedAgenda.sat.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
        case 1:
          this.newAgenda.sun = this.storedAgenda.sun.filter((value) => {
            return value != this.$store.state.activeHour;
          });
          break;
      }
      this.createUpdatedAppointment(day);
    },
    getAgenda() {
      AgendaService.getAgenda(parseInt(this.$route.params.id)).then(
        (response) => {
          this.$store.commit("SET_ACTIVE_AGENDA", response.data);
          this.storedAgenda = response.data;
        }
      );
    },
    findDisabledDates() {
      AgendaService.getDaysOff(parseInt(this.drID)).then((response) => {
        this.$store.commit("SET_DISABLED_DATES", response.data);
      });
    },
    setDaySchedule() {
      if (this.date != null) {
        this.$store.commit("SET_ACTIVE_DATE", this.date);
        const day = this.date.getDay() + 1;
        this.selectedDaySchedule.day = day;
        switch (day) {
          case 2:
            this.selectedDaySchedule.hours = this.storedAgenda.mon;
            break;
          case 3:
            this.selectedDaySchedule.hours = this.storedAgenda.tue;
            break;
          case 4:
            this.selectedDaySchedule.hours = this.storedAgenda.wen;
            break;
          case 5:
            this.selectedDaySchedule.hours = this.storedAgenda.thur;
            break;
          case 6:
            this.selectedDaySchedule.hours = this.storedAgenda.fri;
            break;
          case 7:
            this.selectedDaySchedule.hours = this.storedAgenda.sat;
            break;
          case 1:
            this.selectedDaySchedule.hours = this.storedAgenda.sun;
            break;
        }
        var firstArray = [];

        this.selectedDaySchedule.hours.forEach((hour) => {
          firstArray.push(hour);
        });

        this.$store.commit("SET_ACTIVE_DAY_SCHED", firstArray);

        this.stringDate = this.date;

        var year = this.date.getFullYear();
        var month = (1 + this.date.getMonth()).toString();
        month = month.length > 1 ? month : "0" + month;
        var dateNum = this.date.getDate().toString();
        dateNum = dateNum.length > 1 ? dateNum : "0" + dateNum;
        var dateToString = year + "-" + month + "-" + dateNum;
        this.$store.commit("SET_ACTIVE_STRING_DATE", dateToString);
      }
    },
    displayAppointmentTime(number) {
      var theDate = new Date(this.$store.state.activeDate);
      this.$store.commit("SET_ACTIVE_HOUR", number);
      theDate.setHours(this.$store.state.activeHour, 0, 0);
      this.stringDate = theDate;
      var startTime = "";
      var endTime = "";
      var hourNum = theDate.getHours();
      var endHourNum = theDate.setTime(theDate.getHours() + 1);
      var startTimeConfirm = "";
      if (hourNum < 10) {
        startTime = "0" + hourNum.toString() + ":00:00";
        startTimeConfirm = "0" + number.toString() + ":00";
      } else {
        startTime = hourNum.toString() + ":00:00";
        startTimeConfirm = hourNum.toString() + ":00";
      }
      this.$store.commit("SET_ACTIVE_STRING_TIME_START", startTime);
      var confirmDate = this.$store.state.activeDate.toString();
      var confirmation =
        confirmDate.substring(0, 15) + " at " + startTimeConfirm + " EST";
      this.$store.commit("SET_ACTIVE_CONFIRM", confirmation);

      if (endHourNum < 10) {
        endTime = "0" + endHourNum.toString() + ":00:00";
      } else {
        endTime = endHourNum.toString() + ":00:00";
      }
      this.$store.commit("SET_ACTIVE_STRING_TIME_END", endTime);

      this.showConfirm = true;
    },
    getDoctorInformation() {
      DoctorService.getDoctor(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
      });
    },
  },
  computed: {
    state() {
        return this.value.length === 2
      }
  }
};
</script>


<style>
body {
  font-family: "Helvetica Neue Light", Helvetica, sans-serif;
  padding: 1em 2em 2em;
}

.container {
  display: flex;
  justify-content: center;
  margin-top: 30px;
}
.main {
  background: #f2f2f2;
  border: 1px solid #ddd;
  padding: 2em;
  width: 700px;
  display: grid;
  gap: 10px;
  grid-template-areas:
    "header header"
    "calendar time-slots"
    "content content";
  grid-template-columns: 1fr 1fr;
  align-items: center;
  justify-content: center;
}

.appointment-header {
  grid-area: header;
  padding: 1em 1em 1em auto;
}

.calendar {
  grid-area: calendar;
}

.time-slots {
  grid-area: time-slots;
}

.buttons {
  margin: 2px;
  width: 80px;
}
</style>