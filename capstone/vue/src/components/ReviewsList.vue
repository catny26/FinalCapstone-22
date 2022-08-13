<template>
  <div class="reviews-list">
    <review-display
      v-for="review in $store.state.reviews"
      v-bind:key="review.reviewId"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import reviewService from '@/services/ReviewService.js';
import ReviewDisplay from '@/components/ReviewDisplay.vue';
export default {
  name: "reviews-list",
  components: {
    ReviewDisplay
  },
  created() {
    this.getReviews();
  },
  methods: {
      getReviews(){
        reviewService.getReviews().then((response) => {
          this.$store.commit("SET_REVIEWS", response.data)
        })
      },
      getReviewsByDoctorId(doctorId){
        reviewService.getReviewsByDoctorId(doctorId).then((response) => {
          this.$store.commit("GET_REVIEWS", response.data)
        })
      }
  },
  computed: {
    filteredReviews() {
      const doctorChoice = this.$store.state.doctors.find(
        doctor => doctor.userId == this.$store.state.doctorChoice
      );
      const reviewsFilter = this.$store.state.filter;
      return doctorChoice.reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.stars;
      });
    }
  }
};
</script>

<style>
.reviews-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>