<template>
  <div class = "resources-card">
    <!-- <h3>User Resources</h3> -->
<div class="holder">
    <div class="patient-messages-card">
      <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div>
      <router-link v-bind:to="{ name: 'messages' }">
        <button class="messages">See My Messages</button>
      </router-link>
    </div>

    <div class="patient-appointment-card">
      <patient-appointment-card></patient-appointment-card>
    </div>
</div>
    <div class="portal-card">
      <doctor-portal v-if="isDoctor" />
      <patient-portal v-else />
    </div>

  </div>
</template>

<script>
import PatientAppointmentCard from './PatientAppointmentCard.vue'
import DoctorPortal from './DoctorPortal.vue'
import PatientPortal from './PatientPortal.vue';

export default {
  components: { DoctorPortal, PatientPortal, PatientAppointmentCard},
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
h3{
  grid-area: "header";
}
.resources-card {
  /* display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap; */
  
  display: grid;
  grid-template-areas: 
  "cards"
  "."
  "."
  "portal";
  justify-content: center;
}
.portal-card{
  grid-area: "portal";
  display:flex;
  justify-content:center;
  /* width: 500px;

  margin: 10px;
  padding: 15px; */
}

.holder {
  grid-area: "cards";
  display: flex;
  flex-direction: row;
  /* display: grid;
  grid-template-areas: "space space card1 card2 card3 space space";
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-gap: 10px;
  align-items: center; */
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
</style>