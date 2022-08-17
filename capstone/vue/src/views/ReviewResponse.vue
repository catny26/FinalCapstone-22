<template>
  <div class="review-response">
        <form v-on:submit.prevent="updateCurrentReview">
            <div>
                <label for="response">Enter a Response: </label>
                <textarea id="response" v-model="updatedReview.reviewResponse" />
            </div>
            <div class="actions">
                <input type = "submit" value="Submit">
                <input type="button" value="Cancel" v-on:click.prevent="resetForm">
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
.review-response {
  display: flex;
  flex-direction: column;
  align-items: center;
}
form {
  width: 400px;
  margin: 20px;
  align-items: center;
}
.form-element label {
  width: 100px;
  vertical-align: top;
}
.form-element input, select, textarea {
  width: 400px;
  font-size: 1rem;
}
.form-element textarea {
  height: 100px;
}
.form-element select {
  height: 30px;
}
.form-element select option:hover {
  background-color: grey;
}
.actions {
  display: flex;
  flex-direction: row;
}
</style>