<template>
  <div class = "reviews">
    <h1>Reviews</h1>
    <reviews-list />
    <h2>Submit Review</h2>
    <add-review />
  </div>
</template>

<script>
import ReviewsList from '@/components/ReviewsList.vue'
import AddReview from '@/components/AddReview.vue'
export default {
  name: "reviews",
  components: {
    ReviewsList,
    AddReview
  }
}
</script>

<style>

</style>