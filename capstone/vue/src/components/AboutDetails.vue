<template>
  <div class = "about-details">
    <div>
      <h1>What is TE Health?</h1>
      <p>TE Health is an application that connects doctors and pharmacists to their patients. By allowing doctors and patients to connect and schedule times for either online sessions, emails, or schedule appointments, people will be easily able to see when their doctors are available, and how much the prescriptions will cost upon being prescribed one.</p>
      <p>Until this point, there has been no transparency in scheduling beyond going off of the receptionist time recommendations. By opening up scheduling data, making certain doctors available for urgent calls/drug information request, and allowing complete transparency of staff availability, patients will be more capable of scheduling times that fit their lifestyle.</p>
    </div>

    <div>
      <router-link :to="{ name: 'Home'}">
        Back to Home
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
    name: "about-details"
}
</script>

<style>

</style>