<template>
  <div class="patient-appointment-card">

      <div>
        <img src="../assets/appointment.png" alt="Appointments Image" class="appointments-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/appointments' }">
        <button class="appointments">See My Appointments</button>
      </router-link>

  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>