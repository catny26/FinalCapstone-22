<template>
  <div class = "notifications">
      <h3>Notifications</h3>

  <form v-on:submit.prevent>
    <div class="user">
      <label for="user">{{notification.user}}</label>
      <input type="text" v-model="notification.user" />
    </div>

    <div class="message">
      <label for="message">{{notification.message}}</label>
      <textarea spellcheck="false" v-model="notification.message" />
    </div>

    <div class="is-read">
      <label for="is-read">{{notification.isRead}}</label>
      <textarea spellcheck="false" v-model="notification.isRead" />
    </div>

    <div class="actions">
      <button type="submit" v-on:click="saveNotification()">Save</button>
      <button type="button" v-on:click="cancel()">Cancel</button>
    </div>
  </form>

    <div>
      <router-link :to="{ name: 'Home'}">
        <home>Home</home>
      </router-link>
    </div>
  </div>
</template>

<script>
import Home from "../views/Homes.vue"

export default {
    name: "notifications",
  data() {
    return {
      components: {
        Home
      },
      notification: {
        user: "",
        message: "",
        isRead: false
      }
    };
  },
  methods: {
    saveNotification() {
      Home.create(this.notification).then(response => {
          if (response.status === 201) {
            this.$router.push("/");
          }
        }).catch(error => {
          console.error(error);
        });
    },
    cancel() {
      this.$router.push("/");
    }
  }
};

</script>

<style>

</style>