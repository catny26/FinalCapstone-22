<template>
  <div class = "resources-card">
    <h3>User Resources</h3>
<div class="container">
    <div class="patient-messages-card">
      <patient-messages-card
        :v-show="showMessages"
        v-for="message in this.$store.state.messages"
        v-bind:key="message.id"
        v-bind:message="message">
      </patient-messages-card>
      <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div>
      <!-- <button class="messages" @click="showMessages = !showMessages;">See My Messages</button> -->
      <router-link v-bind:to="{ path:'notification' }">
        <button class="messages">See My Messages</button>
      </router-link>
    </div>

    <div class="patient-appointment-card">
      <patient-appointment-card></patient-appointment-card>
      <!-- <div>
        <img src="../assets/appointment.png" alt="Appointments Image" class="appointments-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/appointments' }">
        <button class="appointments">See My Appointments</button>
      </router-link> -->
    </div>

    <div class="patient-prescription-card">
      <patient-prescription-card></patient-prescription-card>
      <!-- <div>
        <img src="../assets/prescription.png" alt="Prescriptions Image" class="prescriptions-image">
      </div>
      <router-link v-bind:to="{ path: '/portal/prescriptions' }">
        <button class="prescriptions">See My Prescriptions</button>
      </router-link> -->
    </div>
</div>
    <div class="portal-card">
      <doctor-portal v-if="isDoctor" />
      <patient-portal v-else />
    </div>

  </div>
</template>

<script>
import PatientPrescriptionCard from './PatientPrescriptionCard.vue'
import PatientAppointmentCard from './PatientAppointmentCard.vue'
import PatientMessagesCard from './PatientMessagesCard.vue'
import DoctorPortal from './DoctorPortal.vue'
import PatientPortal from './PatientPortal.vue';

export default {
  components: { DoctorPortal, PatientPortal, PatientPrescriptionCard, PatientAppointmentCard, PatientMessagesCard },
  computed:{
    isDoctor(){
        if(!this.isEmpty(this.$store.state.user)){
          if(this.$store.state.user.authorities[0].name == 'ROLE_DOCTOR'){
            return true;
          }
        }
        return false;
      }
  },
  methods:{
    isEmpty(object){
      return Object.keys(object).length == 0;
    }
  },
  data(){
    return {
      showMessages: false
    }
  }
    // name: "user-resources-card",
    // props: ["user-resources"]

}
</script>

<style>
.resources-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
  
}
.portal-card{
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.container {
  display: grid;
  grid-template-areas: "space space card1 card2 card3 space space";
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-gap: 10px;
  align-items: center;
}

.patient-messages-card {
  grid-area: "card1";
  border-radius: 10px;
  width: 500px;
  margin: 10px;
  padding: 15px;
}
.patient-messages-card img {
   width: auto;
  height: 100%;
  padding: 15px;
}

.patient-appointment-card {
  grid-area: "card2";
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.patient-appointment-card img {
  width: auto;
  height: 100%;
  padding: 15px;
}

.patient-prescription-card {
  grid-area: "card3";
  border-radius: 10px;
  width: 500px;
  margin: 10px;
  padding: 15px;
}

.patient-prescription-card img {
   width: auto;
  height: 100%;
  padding: 15px;
}
</style>