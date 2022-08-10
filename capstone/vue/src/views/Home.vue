<template>
  <div class="home">
    <home-card />
    <br>
    <img src="../assets/home-mock.jpg" width="600">
  </div>
</template>

<script>
import HomeCard from "../components/HomeCard.vue";

export default {
  name: "home",
  components: {
    HomeCard
  }
};
</script>
