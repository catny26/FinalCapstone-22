<template>
  <div class="view-container">
    <div class="content">
      <h3>Here are your appointments:</h3>
      <div  v-if="isPatient"
>
      <appointments-by-patient
        v-bind:key="appt.id"
        v-for="appt in this.$store.state.appts"
        v-bind:appt="appt"
      />
      </div>
      <div v-if="isPatient == false">
      <appointments-by-doctor
        v-bind:key="appt.id"
        v-for="appt in this.$store.state.appts"
        v-bind:appt="appt"
      />
      </div>
    </div>
  </div>
</template>

<script>
import AppointmentsByPatient from "@/components/AppointmentsByPatient";
import AppointmentsByDoctor from "@/components/AppointmentsByDoctor";
import AppointmentService from "@/services/AppointmentService";

export default {
  components: { AppointmentsByPatient, AppointmentsByDoctor },
  data() {
    return {
      appt: this.$store.state.appts,
      isPatient: true
    };
  },
  created() {
    if (this.$store.state.user.authorities[0].name == "ROLE_DOCTOR") {
      this.getAppointmentsForDoctor();
      this.isPatient = false;
    } else {
      this.getAppointmentsForPatient();
      this.isPatient = true;
    }
  },
  methods: {
    getAppointmentsForPatient() {
      AppointmentService.getAppointmentsByPatient(
        parseInt(this.$route.params.id)
      ).then((response) => {
        this.$store.commit("SET_ACTIVE_APPTS", response.data);
      });
    },
    getAppointmentsForDoctor() {
      AppointmentService.getAppointmentsByDoctor(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_APPTS", response.data);
      });
    },
  },
};
</script>

<style>
.view-container {
  display: grid;
  grid-template-areas: "space main space";
}
.view-container .content {
  grid-area: "main";
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.content h3 {
  padding: 40px 40px 5px 40px;
}
</style>