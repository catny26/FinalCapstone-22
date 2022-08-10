<template>
  <div class="offices">
    <h1>These are our offices</h1>

    <offices-list />
  </div>
</template>

<script>
import OfficesList from "../components/OfficesList.vue";
export default {
  name: "Offices",
  components: {
    OfficesList,
  },
};
</script>

<style>
</style>