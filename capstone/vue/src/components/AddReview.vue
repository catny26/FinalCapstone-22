<template>
  <div class = "add-review">
    <div class = "container">
    <form v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="rating">Star Rating: </label>
          <select id="rating" v-model.number="newReview.stars">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review: </label>
        <textarea id="review" v-model="newReview.message"></textarea>
      </div>
      <div class="form-element">
        <label for="response">Response: </label>
        <textarea id="response" v-model="newReview.response"></textarea>
      </div>
      <div class="buttons">
        <button v-on:click.prevent="resetForm" >Submit</button>&nbsp;
        <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      </div>
    </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'add-review',
  data() {
    return {
      newReview: {
        reviewId: 0,
        stars: 0,
        message: '',
        doctorId: 0,
        patientId: 0,
        officeId: 0,
        response: ''
      }
    };
  },
  methods: {
    addNewReview() {
      const reviewId = this.$route.params.reviewId;
      this.newReview.reviewId = reviewId;
      this.$store.commit("SET_REVIEW", this.newReview);
      this.$router.push({ name: 'reviews'});
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
  height: 50px;
}
.actions {
  float: right;
}
.actions button {
  margin-left: 10px;
}
</style>