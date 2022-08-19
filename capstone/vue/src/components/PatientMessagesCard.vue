<template>
<div class="page-container">
  <div class="patient-messages-card">
    <div class="messages-container">
      <!-- {{ this.$store.state.user }} -->

      <h2>Here are all your messages:</h2>
      <!-- {{this.isDoctor?"Doctor Resources":"Patient Resources"}} -->
    </div>
    <div class="message-list-container">
      <ul>
        <li
          class="minite"
          v-for="notification in this.$store.state.notifications"
          :key="notification.notificationId"
        >
          {{ notification.message }}
          <!-- {{ notification.notificationId }} -->
          <!-- <img src="../assets/te-button-mini.png" alt="mini-te"> -->
          <!-- {{ this.$store.state.notification }} -->

          <!-- {{ enableAdd }} -->
          <div class="button-container" v-if="!enableAdd">
            <button
              class="mark-read"
              v-on:click.prevent="
                updateMessage(notification, !notification.read)
              "
            >
              {{ notification.read ? "Mark Unread" : "Mark Read" }}
            </button>
            <!-- <button class="confirm-appointment" 
        v-for="appointment in this.$store.state.appointments"
        :key="appointment.appointmentId"
        v-on:click.prevent="confirmApptmt()" 
        id="doctorrole" value="doctor">Confirm Appointment</button> -->
<!-- <<<<<<< HEAD -->
            <!-- v-if="user.isDoctor" -->
          </div>

          <!-- Mark as Read <input type="checkbox" v-on:click.prevent="updateMessages(true)" v-if=" ! notification.isRead">
        Mark as Unread <input type="checkbox" v-on:click.prevent="updateMessages(false)" v-if="notification.isRead"> -->
        </li>
      </ul>
    </div>
    <!-- <h3 v-bind:to="getMessages"></h3>
      <li>"Your appointment is tomorrow at 11AM"</li>
        <li>"Your appointment is currently pending and will need approval from your physician"</li>
        <li>"Your appointment was cancelled successfully"</li> -->

    <div>
      <!-- <img src="data:image/png;base64,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" alt="TElogo" name="TElogo"> -->
    </div>

    <!-- <div>
        <img src="../assets/message.png" alt="Messages Image" class="messages-image">
      </div> -->
<!-- <<<<<<< HEAD -->
    <!-- {{ this.$store.state.notification }} -->
    <!-- <router-link v-bind:to="{ name: 'messages' }">
        <button class="messages">See All Messages</button>
      </router-link> -->
    <ul>
      <!-- <li>"Your appointment is tomorrow at 11AM"</li>
        <li>"Your appointment is currently pending and will need approval from your physician"</li>
        <li>"Your appointment was cancelled successfully"</li> -->
    </ul>
  </div>
  </div>
</template>

<script>
import messageService from "@/services/MessageService.js";
export default {
  name: "patient-messages-card",
  props: {
    notification: Object,
    enableAdd: {
      type: Boolean,
      default: false,
    },
  },

  data() {
    return {
      newNotification: {
        notificationId: 0,
        userId: "",
        message: "",
        isRead: false,
      },
    };
  },
  created() {
    this.getMessages();
  },
  methods: {
    getMessages() {
      messageService.getMessages(this.$store.state.user.id).then((response) => {
        this.$store.commit("SET_NOTIFICATIONS", response.data);
      });
    },
    updateMessage(notification, isRead) {
      notification.read = isRead;
      console.log("notification = " + notification.read);
      messageService
        .updateMessage(notification.notificationId, notification)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("SET_ACTIVE_NOTIFICATION", response.data);
          }
        });
    },
    isDoctor() {
      if (this.isAuthorized) {
        if (this.$store.state.user.authorities[0].name == "ROLE_DOCTOR") {
          return true;
        }
      }
      return false;
    },
    confirmApptmt() {
      console.log("in confirmed appointment");
      //update APPTMT to approve from pending
      //add update method to APPTMT SERVICE
      //(put) to endpoint in java backend
      //send approvedApptMessage:  MessageService.sendMessage(approvedApptMessage)

      //get all pending apptmts for doctor and loop through apptmts
      //find apptmt that is pending that matches patient username + id

      //   const approvedApptmtMessage = {
      //     userId: this.doctorID,
      //     message: "Patient " + this.$store.state.user.fullName + " appointment approved.",
      //     read: true
      //   }
      // }
      // confirmMessages(doctorId) {
      //   messageService.updateMessages(this.$store.state.notification.id).then((response) => {

      //   })
    },
  },
};
</script>

<style>

.page-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.patient-messages-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.messages-container {
  border: 1px solid lightgrey;
  width: 700px;
  background-color: whitesmoke;
  padding: 15px;
}

.message-list-container {
  display: flex;
  font-size: 2vw;
}

.minite {
  list-style: none;
  padding: 10px 30px;
  background-image: url("data:image/png;base64,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");
  background-repeat: no-repeat;
  background-position: left center;
  background-size: 20px;
}
ul {
  color: darkblue;
}
</style>