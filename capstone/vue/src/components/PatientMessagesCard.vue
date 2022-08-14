<template>
  <div class="patient-messages-card">

      <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div>

      <router-link v-bind:to="{ path: '/portal/messages' }">
        <button class="messages">See My Messages</button>
      </router-link>

  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>