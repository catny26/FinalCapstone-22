<template>
  <div>
      <h1 class="appointment-header">
      {{ this.$store.state.user.fullName }}'s Upcoming Schedule:
    </h1>

    <div>

      <v-date-picker
        v-model="selectedDate"
        :model-config="modelConfig"
        :attributes="formattedAppointments"
      ></v-date-picker>
      <div v-if="selectedDate != undefined">
          <h2>Appointments on {{formatDate(this.selectedDate)}}</h2>
          <div class="appointment-cad" v-for="appointment in selectedAppointments" :key="appointment.id">
              <p>An appointment with Doctor {{findDoctorById(appointment.doctorId).fullName}}, at {{formatTime(appointment.startTime.substr(0,2))}} - {{formatTime(appointment.endTime.substr(0,2))}}, for {{appointment.reason}} is {{appointment.status}}</p> 
          </div>
      </div>
    </div>



    <!-- <div class="time-slots">
      <b-button
        variant="primary"
        class="buttons"
        v-for="n in this.$store.state.dayScheduleArray"
        v-bind:key="n"
        v-on:click="displayAppointmentTime(n)"
        >{{ formatTime(n) }}</b-button
      >
      <b-button
        variant="primary"
        class="buttons"
        v-for="n in this.$store.state.eveningScheduleArray"
        v-bind:key="n"
        v-on:click="displayAppointmentTime(n)"
        >{{ formatTime(n) }}</b-button
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
            >Success</b-button
          >
        </div>
        <br /><br />
      </div>
    </div> -->
  </div>
</template>

<script>
import AppointmentService from '@/services/AppointmentService'
import DoctorService from '@/services/DoctorService'

export default {
    created(){
        this.getAppointments();
        if(this.isEmpty(this.$store.state.doctors)){
            DoctorService.getDoctors().then(response=>{
                this.$store.commit('SET_DOCTORS', response.data)
                this.doctors = response.data
            })
        }
        else{
            this.doctors = this.$store.state.doctors
        }
    },
    data(){
        return{
            modelConfig: {
                type: 'string',
                mask: 'YYYY-MM-DD'
            },
            appointments:[],
            selectedDate: undefined,
            doctors: []
        }
    },
    methods:{
        findDoctorById(id){
            return this.doctors.find((doctor)=>{
                return doctor.id == id
            })
        },
        timeComparison(time1, time2){
            time1 = parseInt(time1.substr(0,2))
            time2 = parseInt(time2.substr(0,2))
            return time1-time2
        },
        appointmentSearch(date){
            let output = [];
            this.appointments.forEach((appointment)=>{
                if(appointment.date == date){
                    output.push(appointment)
                }
            })
            output.sort((a,b)=>{
                return this.timeComparison(a.startTime, b.startTime)
            })
            return output;
        },
        formatTime(time){
            let output = undefined;
            if(time > 12){
                output = time%12 + ':00 PM'
            }
            else{
                output = time + ':00 AM'
            }
            return output;
        },
        getAppointments(){
            if(this.isDoctor){
                AppointmentService.getAppointmentsByDoctor(this.$store.state.user.id).then(response=>{
                    this.appointments = response.data;
                })
            }
            else {
                AppointmentService.getAppointmentsByPatient(this.$store.state.user.id).then(response=>{
                    this.appointments = response.data;
                })
            }

            // AppointmentService.getAppointments(this.$store.state.user.id, this.isDoctor)
            // .then(response=>{
            //     this.appointments = response.data;
            // })
        },
        isEmpty(object){
            return Object.keys(object).length == 0
        },
        formatDate(date){
            let dateArray = date.split('-')
            return `${dateArray[1]}/${dateArray[2]}/${dateArray[0]}`
        }
    },
    computed:{
       selectedAppointments(){
           if(this.selectedDate != undefined){
               return this.appointmentSearch(this.selectedDate)
           }
           return undefined;
       },
        formattedAppointments(){
            let events = [{
                key: 0,
                highlight: {
                    color: 'blue',
                    fillMode: 'outline'
                },
                dates: new Date()
            }];
            this.appointments.forEach((appointment)=>{
                const day = appointment.date.split('-')
                const appointmentDate = new Date()
                appointmentDate.setFullYear(day[0])
                appointmentDate.setMonth(day[1] -1)
                appointmentDate.setDate(day[2])
                events.push({
                    key: appointment.id,
                    highlight: true,
                    dates: appointmentDate
                })
            })
            return events
        },
        isDoctor(){
      if(this.isAuthorized){
        if(this.$store.state.user.authorities[0].name == 'ROLE_DOCTOR'){
          return true
        }
    }
        return false
    }
    }
}
</script>

<style>

</style>