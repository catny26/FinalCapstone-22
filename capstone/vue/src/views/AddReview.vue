<template>
  <div class = "add-review">
    <div class = "container">
    <form v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="rating">Star Rating: </label>
          <select id="rating" v-model.number="newReview.amountOfStars">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review: </label>
        <textarea id="review" v-model="newReview.reviewMessage"/>
      </div>
      <div class="form-element">
        <label for="response">Response: </label>
        <textarea id="response" v-model="newReview.reviewResponse" />
      </div>
      <div class="buttons">
        <input type = "submit" value="Submit">&nbsp;
        <input type="button" value="Cancel" v-on:click.prevent="resetForm">&nbsp;
        <router-link v-bind:to="{name: 'reviews'}"><input type="button" value = "Reviews"></router-link>&nbsp;
        <router-link v-bind:to="{name: 'providers'}"><input type="button" value = "Return to Providers"></router-link>
      </div>
    </form>
    </div>
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'
export default {
  name: 'add-review',
  data() {
    return {
      newReview: {
        id: 0,
        amountOfStars: 0,
        reviewMessage: '',
        doctorId: 0,
        patientId: 0,
        officeId: 0,
        reviewResponse: ''
      }
    };
  },
  methods: {
    addNewReview() {
      ReviewService.createReview(this.newReview).then((response) => {
        this.$store.commit('SET_REVIEWS', response.data);
      })
    },
    resetForm() {
      this.newReview = {};
    }
  }
}
</script>

<style>
.add-review {
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
  height: 40px;
}
.buttons {
  display: flex;
  flex-direction: row;
}
</style>