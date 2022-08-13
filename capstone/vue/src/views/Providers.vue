<template>
  <div class="providers">
    <h2>Meet Our Providers</h2>
    <doctors-list />
    <br>
    <img src="../assets/doctors-mock.jpg" width="600">
  </div>
</template>

<script>
import DoctorsList from "@/components/DoctorsList.vue";
export default {
    name: "providers",
    components: {
      DoctorsList
    }
}
</script>

<style>

</style>