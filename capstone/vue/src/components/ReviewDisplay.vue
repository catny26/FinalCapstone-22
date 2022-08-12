<template>
  <div class = "review-display">
    <div class = "star-rating">
      <img
        src="../assets/star.png"
        v-bind:title="review.stars + ' Star Review'"
        class="stars"
        v-for="star in review.stars"
        v-bind:key="star"
      />
    </div>
    
    <h4>{{ review.message }}</h4>
    <p>{{ review.response }}</p>
    
  </div>
</template>

<script>
export default {
  name: "review-display",
  props: ["review"]
}
</script>

<style>

</style>