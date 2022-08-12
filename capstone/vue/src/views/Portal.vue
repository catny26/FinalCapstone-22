<template>
  <div class = "portal">
      <h1>Welcome To Your Portal</h1>
      <doctor-portal v-if="isDoctor" />
      <patient-portal v-else />

  </div>
</template>

<script>
import PatientPortal from '@/components/PatientPortal'
import DoctorPortal from '@/components/DoctorPortal'
export default {
    name: "patient-portal",
    components: {
        PatientPortal,
        DoctorPortal
    },
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
    }
}
</script>

<style>
.portal {
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  align-items: flex-end;
  gap: 20px;
}
</style>