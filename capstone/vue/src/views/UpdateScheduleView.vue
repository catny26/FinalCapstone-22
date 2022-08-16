<template>
  <div>
    <update-schedule v-bind:doctorID="parseInt(this.$route.params.id)" :agenda="this.$store.state.activeAgenda" />
  </div>
</template>

<script>
import UpdateSchedule from "../components/UpdateSchedule.vue";
import AgendaService from "@/services/AgendaService"


export default {
  created() {
    AgendaService.getAgenda(this.$route.params.id).then((response) =>
      this.$store.commit("SET_ACTIVE_AGENDA", response.data)
    );
  },
  components: { UpdateSchedule },
};
</script>

<style>
</style>