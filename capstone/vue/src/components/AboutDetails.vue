<template>
  <div class="about-details">
    <section>
      <div class="about-image">
        <img
          src="../assets/about.png"
          alt="A generic image of a doctors office"
        />
      </div>
    </section>

    <section>
      <div class="text">
        <h1 class="heading">What is TE Health?</h1>

        <p class="content">
          TE Health is a dynamic application that connects doctors and
          pharmacists to their patients. By allowing doctors and patients to
          connect and schedule times for either online sessions, emails, or
          schedule appointments, people will be easily able to see when their
          doctors are available and how much the prescriptions will cost upon
          being prescribed.
        </p>
        <p class="content">
          Until this point, there has been no transparency in scheduling beyond
          going off of the receptionist time recommendations. By opening up
          scheduling data, making certain doctors are available for urgent calls
          or drug information requests, and allowing complete transparency of
          staff availability, patients will be more capable of scheduling times
          that fit their lifestyle.
        </p>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "about-details",
};
</script>

<style>
.about-details {
  display: flex;
  flex-direction: row;
  align-items: center;
  border-radius: 10px;
  width: 70vw;
  margin: 50px 10px 10px 10px;
  padding: 15px;
}

.about-details section {
  display: flex;
  justify-content: center;
  margin: 10px;
  width: 50%;
}

.about-details section img {
    width: 100%;
    height: auto;
}

.about-details h1 {
  /* grid-area: "heading"; */
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}

.about-details p {
  /* grid-area: "content"; */
  font-size: 1.2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

/* .about-details button {
  grid-area: auto;
} */
</style>