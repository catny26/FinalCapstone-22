<template>
  <div class="reviews-list">
    <review-card
      v-for="review in this.$store.state.reviews" v-bind:key="review.id"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js';
import ReviewCard from '@/components/ReviewCard.vue';

export default {
  name: "reviews-list",
  components: {
    ReviewCard
  },
  created() {
    this.retrieveReviews();
 },
  methods: {
    retrieveReviews(){
      ReviewService.getReviewsByDoctorId(this.$route.params.id).then((response) => {
        this.$store.commit("SET_REVIEWS", response.data);
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
}

</script>

<style>
.reviews-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>