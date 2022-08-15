<template>
  <div class="patient-messages-card">
    <h2>Here are all your messages:</h2>
    <h3 v-bind:to="getMessages"></h3>
      <!-- <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div> -->
      {{ this.$store.state.notification }}
      <!-- <router-link v-bind:to="{ name: 'messages' }">
        <button class="messages">See All Messages</button>
      </router-link> -->
      <ul>
        <li>"Your appointment is tomorrow at 11AM"</li>
        <li>"Your appointment is currently pending and will need approval from your physician"</li>
        <li>"Your appointment was cancelled successfully"</li>
      </ul>

  </div>
</template>

<script>
import messageService from '@/services/MessageService.js'
export default {
  name: "patient-messages-card",
  props: ["notification"],
  data() {
    return {
      newNotification: {
        notificationId: 0,
        userId: '',
        message: '',
        isRead: false
      }
    }
  },
  created() {
    this.getMessages();
   
  },
  methods: {
    getMessages() {
      messageService.getMessages(this.$store.state.user.id).then((response) => {
        this.$store.commit('SET_ACTIVE_NOTIFICATION', response.data)
      })
    }
  },
}
</script>

<style>
.patient-messages-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
  
}
</style>