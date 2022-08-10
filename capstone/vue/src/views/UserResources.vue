<template>
   <div class="patient-resources">
    <br>
    <img src="../assets/patient-resources.jpg" width="600">

    <user-resources-card />
  </div>
</template>

<script>
import UserResourcesCard from "../components/UserResourcesCard.vue";

export default {
  name: "user-resources",
  components: {
    UserResourcesCard
  }
}
</script>

<style>

</style>