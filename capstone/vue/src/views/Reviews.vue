<template>
  <div class = "reviews">
    <!-- <h2>Reviews From Our Patients</h2> -->
    <reviews-list />
    <router-link class="link" v-bind:to="{name: 'providers'}"><input type="button" value="Back to Providers List"></router-link>
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
.reviews {
  margin: 10px;
  padding: 15px;
}
/* .reviews h2 {
  color: black;
} */
</style>