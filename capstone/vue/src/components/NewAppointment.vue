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
import MessageService from "@/services/MessageService"

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
      drID: parseInt(this.doctorID),
      storedAgenda: this.agenda,
      date: null,
      selectedDaySchedule: {
        day: "",
        dayStart: "",
        lunchStart: "",
        lunchEnd: "",
        dayEnd: "",
      },
      selectedHour: 0,
      stringDate: "",
      reason: "",
      showConfirm: false,
    };
  },
  methods: {
    submitNewAppt() {
      const newAppt = {
        patientId: this.$store.state.user.id,
        doctorId: this.doctorID,
        agendaId: this.agenda.agendaId,
        startTime: this.$store.state.activeStringTimeStart,
        endTime: this.$store.state.activeStringTimeEnd,
        date: this.$store.state.activeStringDate,
        status: "Pending",
        reason: this.reason,
      };
      const pendingApptMessage = {
        userId: this.doctorID,
        message: "Patient" + this.$store.state.user.fullName + " your appointment is awaiting approval.",
        read: false
      }
      AppointmentService.createAppointment(newAppt).then ((response) => {
        if (response.status === 201) {
          //todo: chk msg response
          //sending msg to doctor
          MessageService.sendMessage(pendingApptMessage)  
          //sending msg to patient
          pendingApptMessage.userId = this.$store.state.user.id
          MessageService.sendMessage(pendingApptMessage)
          alert ("Appointment is Pending. Waiting for Doctor Approval.");

        }
      })
      MessageService.sendMessage(pendingApptMessage)
this.$router.push(`/user/${this.$store.state.user.id}/appointments/`)    },
    getAgenda() {
      AgendaService.getAgenda(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_AGENDA", response.data);
        this.storedAgenda = response.data;
      });
    },
    findDisabledDates() {
      AgendaService.getDaysOff(this.drID).then((response) => {
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
            this.selectedDaySchedule.dayStart = this.storedAgenda.monStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.monEnd;
            break;
          case 3:
            this.selectedDaySchedule.dayStart = this.storedAgenda.tueStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.tueEnd;
            break;
          case 4:
            this.selectedDaySchedule.dayStart = this.storedAgenda.wenStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.wenEnd;
            break;
          case 5:
            this.selectedDaySchedule.dayStart = this.storedAgenda.thurStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.thurEnd;
            break;
          case 6:
            this.selectedDaySchedule.dayStart = this.storedAgenda.friStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.friEnd;
            break;
          case 7:
            this.selectedDaySchedule.dayStart = this.storedAgenda.satStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.satEnd;
            break;
          case 1:
            this.selectedDaySchedule.dayStart = this.storedAgenda.sunStart;
            this.selectedDaySchedule.lunchStart = this.storedAgenda.lunchStart;
            this.selectedDaySchedule.lunchEnd = this.storedAgenda.lunchEnd;
            this.selectedDaySchedule.dayEnd = this.storedAgenda.sunEnd;
            break;
        }
        var firstArray = [];
        for (
          var i = parseInt(this.selectedDaySchedule.dayStart);
          i < parseInt(this.selectedDaySchedule.lunchStart);
          i++
        ) {
          firstArray.push(i);
        }
        this.$store.commit("SET_ACTIVE_DAY_SCHED", firstArray);
        var secondArray = [];
        for (
          var j = parseInt(this.selectedDaySchedule.lunchEnd);
          j < parseInt(this.selectedDaySchedule.dayEnd);
          j++
        ) {
          secondArray.push(j);
        }
        this.$store.commit("SET_ACTIVE_EVE_SCHED", secondArray);
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
      DoctorService.getDoctor(this.doctorID).then((response) => {
        this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
      });
    },
  },
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