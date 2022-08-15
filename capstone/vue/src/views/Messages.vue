<template>
  <div class="messages">
      <!-- <h1>Here are your messages:</h1> -->
      <patient-messages-card></patient-messages-card>
  </div>
</template>

<script>
import PatientMessagesCard from '@/components/PatientMessagesCard'
export default {
    name: "messages",
    components: {
        PatientMessagesCard
    }
}
</script>

<style>

</style>