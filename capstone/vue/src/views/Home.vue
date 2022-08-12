<template>
  <div class="home">
    <br>
    <img src="../assets/home-mock.jpg" width="600">
    <br>
    <notifications />
  </div>
</template>

<script>
import Notifications from "../components/Notifications.vue";
import OfficeService from "../services/OfficeService.js"

export default {
  name: "home",
  components: {
    Notifications,
  },
  created(){
    if(this.$store.state.user.authorities[0].name == "ROLE_DOCTOR"){
      OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then( response=>{
        this.$store.commit('SET_USER_OFFICES', response.data);
      })
    }
  },
};
</script>
