<template>
  <div class="review-list">
    <review-display
      v-for="review in filteredReviews"
      v-bind:key="review.reviewId"
      v-bind:review="review"
    />
  </div>
</template>

<script>
import ReviewDisplay from "@/ReviewDisplay.vue";

export default {
  name: "review-list",
  components: {
    ReviewDisplay
  },
  computed: {
    filteredReviews() {
      const officeChoice = this.$store.state.office.find(
        office => office.officeId == this.$store.state.officeChoice
      );
      const reviewsFilter = this.$store.state.filter;
      return officeChoice.reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.stars;
      });
    }
  }
};
</script>

<style>

</style>