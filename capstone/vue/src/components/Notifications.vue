<template>
  <div class = "notifications">
      <router-link v-bind:to ="{name: 'home'}"><button>Notifications Placeholder</button></router-link>

  <!-- <form v-on:submit.prevent>
    <div class="user">
      <label for = "user">{{notification.user}}</label>
      <input type ="text" v-model="notification.user" />
    </div>

    <div class="message">
      <label for = "message">{{notification.message}}</label>
      <textarea spellcheck="false" v-model="notification.message" />
    </div>

    <div class="is-read">
      <label for="is-read">{{notification.isRead}}</label>
      <input type = "checkbox" v-model="notification.isRead" />
    </div>

    <div class="actions">
      <button type = "submit" v-on:click="saveNotification()">Save</button>
      <button type = "button" v-on:click="cancel()">Cancel</button>
    </div>
  </form> -->

    <!-- <div>
      
      <button >
        <router-link :to="{ name: 'Home'}">
        Return to Home
      </router-link>
      </button>
    </div> -->

<home />

  </div>
</template>

<script>
import Home from "../views/Home.vue"

export default {
  name: "notifications",
  components: {
        Home
  },
  data() {
    return {
      newNotification: {
        notificationId: "",
        user: "",
        message: "",
        isRead: false
      }
    }
  },
  created() {
    this.newNotificationId = parseInt(this.$store.state.notification.notificationId);
    this.$store.commit("SET_NOTIFICATION", this.newNotificationId);
  }

}

</script>

<style>

</style>