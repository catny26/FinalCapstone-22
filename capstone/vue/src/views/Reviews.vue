<template>
  <div class = "reviews">
    <h2>Reviews From Our Patients</h2>
    <reviews-list />
  </div>
</template>

<script>
import ReviewsList from '@/components/ReviewsList.vue'
export default {
  name: "reviews",
  components: {
    ReviewsList
  }
}
</script>

<style>

</style>