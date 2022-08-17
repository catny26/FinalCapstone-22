<template>
  <div class = "add-review">
    <div class = "container">
    <form v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="rating">Star Rating: </label>
        <select id="rating" v-model="newReview.amountOfStars">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>

      <div class="form-element">
        <label for="review">Doctor Name: </label>
        <select id="review" v-model="newReview.doctorId">
          <option value="3">Cathy Ngo</option>
          <option value="4">Noni Crook</option>
          <option value="5">Sam Muskovitz</option>
          <option value="6">Tom Beerbower</option>
          <option value="7">Myron Law-Doom</option>
          <option value="8">Amber Brantley</option>
          <option value="9">Joelle Clayton</option>
          <option value="10">Tara Cherwony</option>
          <option value="11">Shawn Badley</option>
          <option value="12">Jenn Lee</option>
        </select>
      </div>

      <div class="form-element">
        <label for="review">Patient Name: </label>
        <select id="rating" v-model="newReview.patientId">
          <option value="13">Abbie Robers</option>
          <option value="14">Bobi Gilroy</option>
          <option value="15">Christina Ngo</option>
          <option value="16">James Schwartz</option>
          <option value="17">Jamoni Harris</option>
          <option value="18">John Noble</option>
          <option value="19">Joshua Finkeldey</option>
          <option value="20">Matt Nowell</option>
          <option value="21">Michael Kong-Quee</option>
          <option value="22">Mike Still</option>
          <option value="23">Sarah Bond</option>
        </select>
      </div >

      <div class="form-element">
        <label for="review">Office: </label>
        <select id="review" v-model="newReview.officeId">
          <option value="1">Cardiology Consultants of Philadelphia</option>
          <option value="2">Philadelphia Family Medicine</option>
          <option value="3">Thomas Jefferson University Hospital</option>
          <option value="4">Philadelphia Dentistry</option>
        </select>
      </div>

      <div class="form-element">
        <label for="review">Review: </label>
        <textarea id="review" v-model="newReview.reviewMessage"/>
      </div>
      <div class="actions">
        <input type = "submit" value="Submit">
        <input type="button" value="Cancel" v-on:click.prevent="resetForm">
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
        doctorId: '',
        patientId: '',
        officeId: '',
        reviewResponse: ''
      }
    };
  },
  methods: {
    addNewReview() {
      const addedReview = {
        amountOfStars: this.newReview.amountOfStars,
        reviewMessage: this.newReview.reviewMessage,
        doctorId: this.newReview.doctorId,
        patientId: this.newReview.patientId,
        officeId: this.newReview.officeId,
        reviewResponse: this.newReview.reviewResponse
      };
      ReviewService.createReview(addedReview).then((response) => {
        this.$store.commit('SET_REVIEWS', response.data);
      });
      this.newReview = {};
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
  color: grey;
}
.form-element input, select, textarea {
  width: 400px;
  font-size: 1rem;
  border-color: lightgrey;
}
.form-element textarea {
  height: 100px;
}
.form-element select {
  height: 30px;
}
.form-element select option:hover {
  color: grey;
}
.actions {
  display: flex;
  flex-direction: row;
}
</style>