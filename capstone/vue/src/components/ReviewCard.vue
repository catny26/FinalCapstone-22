<template>
  <div class = "review-card">
    <div class = "star-rating">
      <img
        src="../assets/star.png"
        v-bind:title="review.amountOfStars + ' Star Review'"
        class="stars" 
        v-for="n in review.amountOfStars"
        v-bind:key="n"
      />
    </div>
    <h4>{{ review.reviewMessage }}</h4>
    <p><i>Provider's Response: </i>{{ review.reviewResponse }}</p>
    <!-- <router-link class="link" v-bind:to="{name: 'review-response'}"><input type="button" value="Respond to Review" v-if="retrieveReviewById"></router-link>&nbsp; -->
    <router-link class="link" v-bind:to="{name: 'doctors'}"><input type="button" value="Back to Providers List"></router-link>
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'
import DoctorService from '@/services/DoctorService.js'

export default {
  name: "review-card",
  props: ["review", "doctor"],
  created() {
    this.retrieveReview();
    this.getDoctorInformation();
    this.retrieveReviewById();
  },
  data() {
    return {
      storedReview: this.review
    }
  },
  methods: {
    retrieveReview(){
      ReviewService.getReviewsByDoctorId(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_REVIEW", response.data);
      })
    },
    retrieveReviewById(){
      ReviewService.getReview(this.route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_REVIEW", response.data);
        this.storedReview = response.data;
      })
    },
    getDoctorInformation() {
      DoctorService.getDoctor(this.doctorId).then((response) => {
        this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
      })
    }
  }
}
</script>

<style>
.review-card {
  display: flex;
  flex-direction: column;
  /* grid-template-columns: auto; */
  align-items: left;

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}
.review-card img {
  width: 30px;
  height: 30px;
}
.review-card h4 {
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}
.review-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}
</style>