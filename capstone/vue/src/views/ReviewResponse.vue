<template>
  <div class="review-response">
        <form v-on:submit.prevent="updateReview">
            <div>
                <label for="response">Enter Response: </label>
                <textarea id="response" v-model="updatedReview.reviewResponse" />
            </div>
            <div class="buttons">
                <input type = "submit" value="Submit">&nbsp;
                <input type="button" value="Cancel" v-on:click.prevent="resetForm">&nbsp;
                <router-link v-bind:to="{name: 'providers'}"><input type="button" value = "Return to Providers"></router-link>
            </div>
        </form>
    </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'
// import ReviewCard from '@/components/ReviewCard.vue'

export default {
    name: 'review-response',
    props: ["review", "doctor"],
data() {
    return {
      updatedReview: {
        reviewId: 0,
        amountOfStars: 0,
        reviewMessage: '',
        doctorId: '',
        patientId: '',
        officeId: '',
        reviewResponse: ''
      }
    };
  },
  methods: {
    updateCurrentReview() {
      const updatedReview = {
        reviewId: this.reviewResponse.reviewId,
        amountOfStars: this.reviewResponse.amountOfStars,
        reviewMessage: this.reviewResponse.reviewMessage,
        doctorId: this.reviewResponse.doctorId,
        patientId: this.reviewResponse.patientId,
        officeId: this.reviewResponse.officeId,
        reviewResponse: this.reviewResponse.reviewResponse
      };
      ReviewService.respondToReview(updatedReview).then((response) => {
        this.$store.commit('SET_REVIEWS', response.data);
      });
      this.updatedReview = {};
    },
    resetForm() {
      this.updatedReview = {};
    }
  }
}
</script>

<style>

</style>