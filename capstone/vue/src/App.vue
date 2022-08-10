<template>
  <div id="app">
    <header>
      <h1>TE Health</h1>
      </header>
    <div id="nav">
      <div>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;<router-link v-bind:to="{ name: 'offices' }">Offices</router-link>&nbsp;|&nbsp;<router-link v-bind:to="{ name: 'providers' }">Providers</router-link>&nbsp;|&nbsp;<router-link v-bind:to="{ name: 'patient-resources' }">Patient Resources</router-link>&nbsp;|&nbsp;<router-link v-bind:to="{ name: 'login' }">Login</router-link>
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <div class="view">
    <router-view style="margin:0 auto;"/>
    </div> 
    <footer style="height: 100px"/>
  </div>
</template>

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