<template>
  <div class = "resources-card">
    <h3>User Resources</h3>

    <div class="patient-messages-card">
      <patient-messages-card
        v-for="message in this.$store.state.messages"
        v-bind:key="message.id"
        v-bind:message="message">
      </patient-messages-card>
      <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div>
      <router-link v-bind:to="{ name: 'messages' }">
        <button class="messages">See My Messages</button>
      </router-link>
    </div>

    <div class="patient-appointment-card">
      <patient-appointment-card></patient-appointment-card>
      <div>
        <img src="../assets/appointment.png" alt="Appointments Image" class="appointments-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/appointments' }">
        <button class="appointments">See My Appointments</button>
      </router-link>
    </div>

    <div class="patient-prescription-card">
      <patient-prescription-card></patient-prescription-card>
      <div>
        <img src="../assets/prescription.jpg" alt="Prescriptions Image" class="prescriptions-image">
      </div>
      <router-link v-bind:to="{ path: '/portal/prescriptions' }">
        <button class="prescriptions">See My Prescriptions</button>
      </router-link>
    </div>

  </div>
</template>

<script>
export default {
    // name: "user-resources-card",
    // props: ["user-resources"]

}
</script>

<style>
.resources-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
  
}
.patient-messages-card {

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}
.patient-appointment-card {

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}
.patient-prescription-card {

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}
/* #grid{
  display: grid;
  width: 80;
  grid-template-rows: 60px 1fr;

} */
</style>