<template>
  <div class = "review-display">
    <div class = "star-rating">
      <img
        src="../assets/star.png"
        v-bind:title="review.amountOfStars + ' Star Review'"
        class="stars" 
        v-for="n in review.amountOfStars"
        v-bind:key="n"
      />
    </div>
    <h4 v-bind="retrieveReview">{{ review.reviewMessage }}</h4>
    <p><i>Provider's Response: </i>{{ review.reviewResponse }}</p>
    <router-link v-bind:to="{name: 'providers'}"><button>Back to Providers List</button></router-link>
  </div>
</template>

<script>
import reviewService from '@/services/ReviewService.js'
export default {
  name: "review-display",
  props: ["review"],
  created() {
    this.retrieveReview();
  },
  methods: {
    retrieveReview(){
      reviewService.getReview(this.$route.review).then((response) => {
      this.$store.commit("SET_ACTIVE_REVIEW", response.data);
      })
    }
  }
  
}
</script>

<style>
.review-display {
  display: grid;
  /* flex-direction: column; */
  grid-template-rows: auto auto auto;
  align-items: center;

  border: 2px solid black;
  border-radius: 10px;
  width: 600px;

  margin: 10px;
  padding: 15px;
}
.review-display img {
  width: 30px;
  height: 30px;
}
</style>