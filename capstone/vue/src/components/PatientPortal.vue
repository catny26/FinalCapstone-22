<template>
  <div class = "patient-portal">
      <!-- <portal-card
      v-for="portal in this.$store.state.portal" v-bind:key="portal.id"
      v-bind:portal="portal">
      </portal-card> -->
    
      <h1 class = "portal-heading">Welcome Back to Your Portal!</h1>

    <!-- <thead>
      <tr>
        <th>Messages</th>
        <th>Appointments</th>
        <th>Prescriptions</th>
      </tr>
    </thead>
    <tbody>
        <tr v-for="elements in this.$store.state.portal" v-bind:key="elements.id">
            <td>{{ elements.id }}</td>
            <td>
                <router-link v-bind:to="{ name: 'messages', params: { id:elements.id }}"></router-link>
            </td>
            <td>
                <router-link v-bind:to="{ name: 'appointments', params: { id:elements.id }}"></router-link>
            </td>
            <td>
                <router-link v-bind:to="{ name: 'prescriptions', params: { id:elements.id }}"></router-link>
            </td>
        </tr>
    </tbody> -->
    
<!-- I originally made a portal-row file with the intent to display the messages/apptmts/rx elements in three different rows,
but did not make that file here in case we weren't going to use it -->

        <!-- <portal-row
            title="Messages"
            :cards="messages"
            :portalID="this.portalID"
        >
        </portal-row> -->
        <!-- <portal-row
            title="Appointments"
            :cards="appointments"
            :portalID="this.portalID"
        >
        </portal-row> -->
        <!-- <portal-row
            title="Prescriptions"
            :cards="prescriptions"
            :portalID="this.portalID"
        >
        </portal-row> -->

  </div>
</template>

<script>
// import PortalRow from "@/components/PortalRow.vue";
// import PortalCard from "@/components/PortalCard.vue";
// import PortalService from "@/services/PortalService.vue";
export default {
    // name: 'patient-portal',
    // components: {
    //     PortalRow,
    //     PortalCard,
    // },
    
    // created() {
    //     this.retrievePortals();
    // },
    // methods: {
    //   retrievePortals(){
    //     PortalService.getPortals().then(response => {
    //       this.$store.commit("SET_PORTALS", response)
    //     })
    //   }
    // },
    // computed: {
    // card() {
    //   return this.$store.state.card;
    // },
    // messages() {
    //   return this.$store.state.portalCard.filter(
    //     (card) => card.status === "Messages"
    //   );
    // },
    // appointments() {
    //   return this.$store.state.portalCard.filter(
    //     (card) => card.status === "Appointments"
    //   );
    // },
    // prescriptions() {
    //   return this.$store.state.portalCard.filter(
    //     (card) => card.status === "Prescriptions"
    //   );
    // },
//   },
//   data() {
//     return {
//       title: "",
//     };
//   },
}


</script>

<style>

</style>