<template>
  <div class="reviews-list">
    <review-card
      v-for="review in this.$store.state.reviews" v-bind:key="review.id"
      v-bind:review="review"
    />

    {{this.$route.params.id}}
  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js';
// import DoctorService from '@/services/DoctorService.js';
import ReviewCard from '@/components/ReviewCard.vue';

export default {
  name: "reviews-list",
  components: {
    ReviewCard
  },
  created() {
    this.retrieveReviews();
    // this.getReview(this.id);
    // this.getDoctorInformation(this.doctorId);
  },
  methods: {
    retrieveReviews(){
      ReviewService.getReviewsByDoctorId(this.$route.params.id).then((response) => {
        this.$store.commit("SET_ACTIVE_REVIEW", response.data);
      })
    },
    // getReview(id) {
    //   ReviewService.getReview(id).then((response) => {
    //     this.$store.commit("SET_ACTIVE_REVIEW", response.data);
    //   })
    // },
    // getDoctorInformation() {
    //   DoctorService.getDoctor(this.doctorId).then((response) => {
    //     this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
    //   })
    // }
  }

  // computed: {
  //   filteredReviews() {
  //     const doctorChoice = this.$store.state.doctors.find(
  //       doctor => doctor.userId == this.$store.state.doctorChoice
  //     );
  //     const reviewsFilter = this.$store.state.filter;
  //     return doctorChoice.reviews.filter(review => {
  //       return reviewsFilter === 0 ? true : reviewsFilter === review.stars;
  //     });
  //   }
  // }
};
</script>

<style>
.reviews-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>