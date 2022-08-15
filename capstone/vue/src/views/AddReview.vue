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
        <label for="review">Doctor ID: </label>
        <select id="review" v-model="newReview.doctorId">
          <option value="23">test</option>
          <option value="4">test doctor</option>
          <option value="5">Paulien Vlad</option>
          <option value="6">Nanuk Eva</option>
          <option value="7">Noni Clark</option>
          <option value="8">Cathy Ngo</option>
          <option value="9">Jenn Lee</option>
          <option value="10">Sam Muskovitz</option>
          <option value="11">Juhani Muhamad</option>
          <option value="12">Rhode Beata</option>
          <option value="13">Daniela Gusta</option>
          <option value="14">Giorgos Sachiko</option>
          <option value="15">Ivo Uther</option>
          <option value="16">Tom Beerbower</option>
          <option value="17">Myron Law-Doom</option>
          <option value="18">Gervaise Antton</option>
          <option value="19">Gwenneth Dotty</option>
          <option value="20">Agnija Eliana</option>
          <option value="21">Krystyna Eugen</option>
          <option value="22">Catherine Karen</option>
        </select>
      </div>

      <div class="form-element">
        <label for="review">Patient ID: </label>
        <select id="rating" v-model="newReview.patientId">
          <option value="1">user</option>
          <option value="3">test patient</option>
          <option value="24">Bojidar Veronika</option>
          <option value="25">Oberon Valentina</option>
          <option value="26">Tanguy Dorotea</option>
          <option value="27">Starr Kisecawchuck</option>
          <option value="28">Aleksander Tjeerd</option>
          <option value="29">Sietske Magdalena</option>
          <option value="30">Brandon Butler</option>
          <option value="31">Zotikos Monica</option>
          <option value="32">Halina Steel-Crash</option>
          <option value="33">Orna Chisomo</option>
        </select>
      </div >

      <div class="form-element">
        <label for="review">Office ID: </label>
        <select id="review" v-model="newReview.officeId">
          <option value="1">Cardiology Consultants of Phila</option>
          <option value="2">Philadelphia Family Medicine</option>
          <option value="3">Ninth Street Internal Medicine</option>
          <option value="4">Philadelphia Dentistry</option>
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
.buttons {
  display: flex;
  flex-direction: row;
}
</style>