<template>
  <div class = "reviews">
    <h2>Reviews From Our Patients</h2>
    <reviews-list />
    <h2>Submit a Review</h2>
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