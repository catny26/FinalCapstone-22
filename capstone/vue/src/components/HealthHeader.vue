<template>
  <div id="app">
    <header class="header" id="head">
      <img src="../assets/logote.png" alt="TE Health Logo">
    </header>

    <div class="links-container">
      <b-nav fill class="links"
        ><b-nav-item class="tab" style="color:white" active v-bind:to="{ name: 'home' }"
          >Home</b-nav-item
        >
        <b-nav-item class="tab" active v-bind:to="{ name: 'offices' }"
          >Offices</b-nav-item
        >
        <b-nav-item class="tab" active v-bind:to="{ name: 'providers' }"
          >Providers</b-nav-item
        >
        <b-nav-item class="tab" active v-bind:to="{ name: 'patient-resources' }"
          >Patient Resources</b-nav-item
        >
        <b-nav-item class="tab" active v-bind:to="{ name: 'appointments' }"
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
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@300;600;800&display=swap");

.header {
  height: 120px;
    display: flex;
  flex-direction: row;
  align-items: center;

  justify-items: center;  
  background-color: #FFFFFF;
  color: black;
  width: 800px;
}

.header img {
width: auto;
height: 100%;

}

.header h1 {
  width: auto;
}
a:hover {
  transition: 0.7s;
  color: white;
}
a {
  color: white;
  text-decoration: none;
}


a:link {
  color: white;
}

a:visited {
  color: white;
}

#head h1 {
  font-family: "Montserrat", sans-serif;
  font-weight: 600 !important;
  font-size: 60px;
  margin: 0px;
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