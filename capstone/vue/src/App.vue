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
  created(){
    if(this.$store.state.offices.length == 0){
      OfficeService.getOffices().then(response=>{
        this.$store.commit('SET_OFFICES', response.data);
      })
    }
      if(this.$store.state.officesUserBelongsTo.length == 0 && !this.isEmpty(this.$store.state.user)){
      OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
        this.$store.commit('SET_USER_OFFICES', response.data);
      })
    }

  },
  components: {
    HealthHeader
  },
  methods:{
    isEmpty(object){
      return Object.keys(object).length == 0;
    }
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