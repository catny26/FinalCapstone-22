<template>
  <div class = "doctors-list">
    <doctor-card 
    v-for="doctor in this.$store.state.doctors" 
    v-bind:key="doctor.userId"
    v-bind:doctor="doctor"
    />
  </div>
</template>

<script>
import doctorService from "@/services/DoctorService.js"
import DoctorCard from "@/components/DoctorCard.vue"
export default {
    name: "doctors-list",
    components: {
      DoctorCard
    },
    created() {
      this.getDoctors();
      this.getDoctorsByOfficeId();
    },
    methods: {
      getDoctors() {
        doctorService.getDoctors().then((response) => {
          this.$store.commit("SET_DOCTORS", response.data);
        })
      },
      getDoctorsByOfficeId(officeId) {
        doctorService.getDoctorsByOfficeId(officeId).then((response) => {
          this.$store.commit("SET_DOCTORS_IN_OFFICE", response.data);
        })
      }
    }
}
</script>

<style>
.doctors-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>