<template>
<div>

      <div>
        <img src="../assets/prescription.png" alt="Prescription Image" class="prescription-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/prescriptions' }">
        <button class="prescriptions">See My Prescriptions</button>
      </router-link>

  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>