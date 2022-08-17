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

    <router-link v-bind:to="{name: 'review-response', params: {id: this.$route.params.id}}"><input type="button" value="Respond to Review"></router-link>&nbsp;
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'

export default {
  name: "review-card",
  props: ["review", "doctor"],
  created() {
    this.retrieveReview();
    // this.retrieveReviewById();
    // this.addResponse();
  },
  // data() {
  //   return {
      
  //   }
  // },
  methods: {
    retrieveReview(){
      ReviewService.getReviewsByDoctorId(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_REVIEW", response.data);
      })
    }
    // addResponse() {
    //   ReviewService.respondToReview(this.id, this.review).then((response) => {
    //     this.$store.commit('SET_ACTIVE_REVIEW', response.data);
    //   })
    // }
  }
}
</script>

<style>
.review-card {
  display: flex;
  flex-direction: column;
  align-items: center;

  border: 1px solid lightgrey;
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
  text-align: center;
}
.review-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}
</style>