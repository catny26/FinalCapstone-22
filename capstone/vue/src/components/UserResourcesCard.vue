<template>
  <div class = "resources-card">
    <h3>User Resources</h3>

    <div class="patient-messages-card">
      <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div>
      <router-link v-bind:to="{ path: '/portal/messages' }">
        <button class="messages">See My Messages</button>
      </router-link>
    </div>

    <div class="patient-appointment-card">
      <div>
        <img src="../assets/appointment.png" alt="Appointments Image" class="appointments-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/appointments' }">
        <button class="appointments">See My Appointments</button>
      </router-link>
    </div>

    <div class="patient-prescription-card">
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
#grid{
  display: grid;
  width: 80;
  grid-template-rows: 60px 1fr;

}
</style>