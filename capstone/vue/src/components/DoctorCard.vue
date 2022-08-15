<template>
    <div class = "doctor-card">
      <div class="heading">
        <img src="..\assets\dr-mock.jpg" alt="Doctor Photo" class = "doctor-photo">
        <h4>{{doctor.fullName}}, {{doctor.typeOfDoctor}}</h4>
        <!-- <img src="..\assets\star.png" alt="Star Rating" class="stars"> -->
      </div>
      <div class="link">
        <router-link v-bind:to="{name: 'offices'}"><input type="button"  value="Office Information"></router-link>&nbsp;
        <router-link v-bind:to="{name: 'reviews'}"><input type="button" value="See Reviews"></router-link>&nbsp;
        <router-link v-bind:to="{name: 'add-review'}"><input type="button" value="Add a Review"></router-link>
      </div>
    </div>
</template>

<script>
import OfficeService from '@/services/OfficeService.js'
import ReviewService from '@/services/ReviewService.js'
import DoctorService from '@/services/DoctorService.js'

export default {
    name: "doctor-card",
    props:["review", "doctor"],
    created() {
      this.getReview();
      this.getDoctorInformation
      this.getOffices
    },
    data() {
      return {
        doctorId: parseInt(this.doctorId),
        storedReview: this.review,
      }
    },
    methods: {
        getOffices(userId) {
          OfficeService.getOfficesByDoctorId(userId).then((response) => {
            this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
          })
        },
        getReview() {
          ReviewService.getReview(this.$route.params.id).then((response) => {
            this.$store.commit("SET_ACTIVE_REVIEW", response.data);
            this.storedReview = response.data;
          });
        },
        getDoctorInformation() {
          DoctorService.getDoctor(this.doctorId).then((response) => {
            this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
      });
    }
  }
}
</script>

<style>
.doctor-card {
  display: grid;

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.doctor-photo {
  display: block;
  width: 80px;
  height: 80px;
}
.stars {
  width: 15px;
  height: 15px;
}
.doctor-card h4 {
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

.doctor-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}
.heading {
  display: flex;
  flex-direction: row;
  margin: 5px;
  padding: 5px;
}
.link {
  display: flex;
  flex-direction: row;
}
</style>