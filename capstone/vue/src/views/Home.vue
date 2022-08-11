<template>
  <div class="home">
    <br>
    <img src="../assets/home-mock.jpg" width="600">
    <br>
    <notifications />
  </div>
</template>

<script>
import Notifications from "../components/Notifications.vue";

export default {
  name: "home",
  components: {
    Notifications
  }
};
</script>
