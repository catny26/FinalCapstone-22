<template>
  <div class = "about">
    <about-details />
  </div>
</template>

<script>
import AboutDetails from "../components/AboutDetails.vue";
export default {
    name: "about",
    components: {
      AboutDetails
    }
}
</script>

<style>
.about {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>