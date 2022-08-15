<template>
  <div>
    <new-appointment v-bind:doctorID="parseInt(this.$route.params.id)" :agenda="this.$store.state.activeAgenda" />
  </div>
</template>

<script>
import AgendaService from "@/services/AgendaService"
import NewAppointment from "../components/NewAppointment.vue";


export default {
  created() {
    AgendaService.getAgenda(this.$route.params.id).then((response) =>
      this.$store.commit("SET_ACTIVE_AGENDA", response.data)
    );
  },
  components: { NewAppointment },
};
</script>

<style>
</style>