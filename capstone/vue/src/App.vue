<template>
  <div id="app">
    <health-header/>
  </div>
</template>

<script>
import HealthHeader from "@/components/HealthHeader.vue"
import OfficeService from '@/services/OfficeService'
//import DoctorService from '@/services/DoctorService'

export default{
  components: {
    HealthHeader
  },
  created(){
    if(this.$store.state.offices.length == 0){
      OfficeService.getOffices().then(response=>{
        this.$store.commit('SET_OFFICES', response.data);
      })
    }
      if(this.$store.state.officesUserBelongsTo.length == 0){
      OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
        this.$store.commit('SET_USER_OFFICES', response.data);
      })
    }
  //   if(this.$store.state.doctorsInOffice.length == 0){
  //     DoctorService.getDoctorsInOffice(this.$route.params.officeId).then(response=>{
  //       this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
  //     })
  // }

}
  }
</script>


<style>
#index {
  margin: 0px !important;
  padding: 0px !important;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}

</style>