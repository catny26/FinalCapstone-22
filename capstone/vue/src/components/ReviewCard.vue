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
    <p v-if="this.review.reviewResponse != ''">Response: {{review.reviewResponse}}</p>
    <router-link v-bind:to="{name: 'review-response', params: {id: this.review.reviewId}}"><input type="button" value="Respond to Review" @click="setActiveReview"></router-link>&nbsp;
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'

export default {
  name: "review-card",
  props: ["review", "doctor"],
  created() {
    this.retrieveReview();
  },
  methods: {
    setActiveReview(){
      this.$store.commit('SET_ACTIVE_REVIEW', this.review);
    },
    retrieveReview(){
      ReviewService.getReviewsByDoctorId(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_REVIEW", response.data);
      })
    }
  }
}
</script>

<style>
.review-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid lightgrey;
  /* border-radius: 10px; */
  width: 500px;
  background-color: whitesmoke;
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
  text-align: center;
}
.review-card p {
  font-size: 1.2vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}
</style>