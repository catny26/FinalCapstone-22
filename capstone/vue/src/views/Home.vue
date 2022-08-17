<template>
  <div class = "about">
    <about-details />

    <!-- <notifications /> -->
  </div>
</template>

<script>
import OfficeService from "../services/OfficeService.js"
import AboutDetails from "../components/AboutDetails.vue";

export default {
  name: "home",
  components: {
    AboutDetails
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

<style>
.about {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>