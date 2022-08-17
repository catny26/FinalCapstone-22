<template>
  <div class="review-response">
        <form v-on:submit.prevent="updateCurrentReview">
            <div>
                <label for="response">Enter a Response: </label>
                <textarea id="response" v-model="updatedReview.reviewResponse" />
            </div>
            <div class="actions">
                <input type = "submit" value="Submit" @click="getReview()">
                <input type="button" value="Cancel" v-on:click.prevent="resetForm">
                <router-link v-bind:to="{name: 'providers'}"><input type="button" value = "Return to Providers"></router-link>
            </div>
        </form>
    </div>
</template>

<script>
//import ReviewService from '@/services/ReviewService.js'
// import ReviewCard from '@/components/ReviewCard.vue'

export default {
    name: 'review-response',
    props: ["doctor"],
    // components: {
    //   ReviewCard
    // },
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
  // created(){
  //   if(this.$store.state.review.reviewId != 0){
  //     this.review = this.$store.state.review
  //   } else {
  //     this.reviews = this.$store.state.reviews
  //     this.reviews.forEach(review=>{
  //       if(review.reviewId == this.$route.params.id){
  //         this.review = review;
  //       }
  //     })
  //   }
  // },
  methods: {
    getReview(){
      let output = null;
      console.log('review updated')
      if(this.reviews.length !=0){
        this.reviews.forEach(review=>{
          if(review.reviewId == this.$route.params.id){
            review.reviewResponse = this.updatedReview.reviewResponse
            output = review
          }
        })
      }
      this.updatedReview = output;
    },
    updateCurrentReview() {
      // const updatedReview = {
      //   reviewId: this.reviewResponse.reviewId,
      //   amountOfStars: this.reviewResponse.amountOfStars,
      //   reviewMessage: this.reviewResponse.reviewMessage,
      //   doctorId: this.reviewResponse.doctorId,
      //   patientId: this.reviewResponse.patientId,
      //   officeId: this.reviewResponse.officeId,
      //   reviewResponse: this.reviewResponse.reviewResponse
      // };
      // ReviewService.respondToReview(this.$route.params.id).then((response) => {
      //   this.$store.commit('SET_REVIEWS', response.data);
      // });
      // this.updatedReview = {};
      console.log('updated')
    },
    resetForm() {
      this.updatedReview = {};
    }
  },
  computed: {
    reviews(){
      return this.$store.state.reviews
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