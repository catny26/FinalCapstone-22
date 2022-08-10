<template>
  <div id="app">
    <health-header/>
  </div>
</template>

<script>
import HealthHeader from "@/components/HealthHeader.vue"

export default{
  components: {
    HealthHeader
  }
}
</script>


<style>

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}

</style>