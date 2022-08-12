<template>
  <div class="reviews-list">
    <review-display
      v-for="review in filteredReviews"
      v-bind:key="review.reviewId"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewDisplay from "@/components/ReviewDisplay.vue";
export default {
  name: "reviews-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      const providerChoice = this.$store.state.providers.find(
        provider => provider.userId == this.$store.state.providerChoice
      );
      const reviewsFilter = this.$store.state.filter;
      return providerChoice.reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.stars;
      });
    }
  }
};
</script>

<style>

</style>