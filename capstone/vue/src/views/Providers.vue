<template>
  <div class="providers">
    <br>
    <img src="../assets/doctors-mock.jpg" width="600">

    <providers-list />
  </div>
</template>

<script>
import ProvidersList from "../components/ProvidersList.vue";

export default {
    name: "providers",
    components: {
      ProvidersList
    }
}
</script>

<style>

</style>