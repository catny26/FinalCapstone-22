<template>
  <div id="app">
    <header class="header" id="head">
      <img id="header-image" src="../assets/teHealthLogo.png" alt="TE Health Logo">
      <h1 id="header-h1">{{this.welcomeText}}</h1>
    </header>

    <div class="links-container">
      <b-nav fill class="links"
        ><b-nav-item class="tab home" style="color:white" active v-bind:to="{ name: 'home' }"
          >Home</b-nav-item
        >
        <b-nav-item class="tab offices" active v-bind:to="{ name: 'offices' }"
          >Offices</b-nav-item
        >
        <b-nav-item class="tab providers" active v-bind:to="{ name: 'providers' }"
          >Providers</b-nav-item
        >
        <b-nav-item class="tab resources" v-if="isAuthorized" active v-bind:to="{ name: 'patient-resources' }"
          >{{this.isDoctor?"Doctor Resources":"Patient Resources"}}</b-nav-item
        >
        <b-nav-item class="tab appointments" v-if="isAuthorized" active v-bind:to="{ name: 'appointments' }"
          >Make An Appointment</b-nav-item
        >

        <b-nav-item
          class="tab"
          v-bind:to="{ name: 'login' }"
          v-if="$store.state.token == ''"
          active
          >Login</b-nav-item
        >
        <b-nav-item
          class="tab"
          active
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</b-nav-item
        >
      </b-nav>
    </div>
    <div class="view">
      <router-view />
    </div>
    <footer style="height: 100px" />
  </div>
</template>

<script>
export default {
  name: "health-header",
  props: ["tabs", "fill"],
  computed:{
    isAuthorized(){
      return !this.isEmpty(this.$store.state.user);
    },
    isDoctor(){
      if(this.isAuthorized){
        if(this.$store.state.user.authorities[0].name == 'ROLE_DOCTOR'){
          return true
        }
    }
        return false
    },
    welcomeText(){
      if(!this.isEmpty(this.$store.state.user)){
        if(this.isDoctor){
          return `Welcome Dr. ${this.$store.state.user.fullName}!`
        }
        return `Welcome ${this.$store.state.user.fullName}!`
      }
      return null
    }
  },
  methods:{
    isEmpty(object){
        return Object.keys(object).length ==0;
      }
  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;600;800&display=swap");

.header {
  height: 120px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  background-color: #FFFFFF;
  color: black;
  width: auto;
}

#header-image {
width: auto;
height: 100%;
order: 1;
}

#header-h1 {
  width: auto;
  order: 2;
}

.links-container a {
  color: white;
  text-decoration: none;
}


.links-container a:link {
  color: whitet
}

.links-container a:visited {
  color: white;
}

#head h1 {
  font-family: "Montserrat", sans-serif;
  font-weight: 600 !important;
  font-size: 30px;
  margin-right: 60px;
  /* margin: 0px; */
}

.links-container {
  margin: 0px;
  font-weight: 300;
}

.links {
  vertical-align: top;
  margin: 0px;
  background-color: #2873bf;
}

.links > * {
  margin: 0px;
  padding-top: 10px;
}

.tab:hover {
  background-color: #fff;
  transition: 0.7s;
  color: #2873bf !important;
  text-decoration: none;
}

.tab {
  width: auto;
  vertical-align: top;
  color: white !important;
  font-weight: bold;
  padding-bottom: 10px;
}

</style>