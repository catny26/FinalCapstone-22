<template>
  <div class="providers">
    <h2>Meet Our Providers</h2>
    <doctors-list />
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
.providers {
  margin: 10px;
  padding: 15px;
}
.providers h2 {
  color: black;
}
</style>