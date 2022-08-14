<template>
  <div class = "about-details">
    <div>
      <h1 class = "heading">What is TE Health?</h1>
      <img src="../assets/generic_office_image.jpg" alt="A generic image of a doctors office">

      <p class = "content">TE Health is a dynamic application that connects doctors and pharmacists to their patients. By allowing doctors and patients to connect and schedule times for either online sessions, emails, or schedule appointments, people will be easily able to see when their doctors are available and how much the prescriptions will cost upon being prescribed.</p>
      <p class = "content">Until this point, there has been no transparency in scheduling beyond going off of the receptionist time recommendations. By opening up scheduling data, making certain doctors are available for urgent calls or drug information requests, and allowing complete transparency of staff availability, patients will be more capable of scheduling times that fit their lifestyle.</p>
    </div>

  </div>
</template>

<script>
export default {
    name: "about-details"
}
</script>

<style>
.about-details {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.about-details img{
  display: block;
  width: 100%;
  height: 25%;
  align-items: center;
}

.about-details h1 {
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}

.about-details p {
  font-size: 1.2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

</style>