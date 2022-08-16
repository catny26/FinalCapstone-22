<template>
  <div>

      <div>
        <img src="../assets/appointment.png" alt="Appointments Image" class="appointments-image">
      </div>

      <router-link v-bind:to="{ name: 'user-schedule', params:{id: this.$store.state.user.id}}">
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