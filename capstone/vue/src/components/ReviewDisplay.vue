<template>
  <div class = "review-display">
    <div class = "star-rating">
      <img
        src="../assets/star.png"
        v-bind:title="review.stars + ' Star Review'"
        class="stars" 
        v-for="n in review.stars"
        v-bind:key="n"
      />
    </div>
    <h4>{{ review.message }}</h4>
    <p>{{ review.response }}</p>
    <router-link v-bind:to="{name: '/reviews-details'}">Review Details</router-link>
  </div>
</template>

<script>
export default {
  name: "review-display",
  props: ["review"],


}
</script>

<style>
.review-display {
  display: flex;
  flex-direction: column;
  align-items: center;

  border: 2px solid black;
  border-radius: 10px;
  width: 400px;

  margin: 10px;
  padding: 15px;
}
</style>