<template>
    <div class = "doctor-card">
      <div class="heading">
        <img src="..\assets\original1.png" alt="Doctor Icon" class = "doctor-icon">
        <h4>{{doctor.fullName}}, {{doctor.typeOfDoctor}}</h4>
        <!-- <img src="..\assets\star.png" alt="Star Rating" class="stars"> -->
      </div>
      <div class="actions">
        <router-link :to="{name: 'offices'}"><input type="button"  value="Office Information"></router-link>
        <router-link :to="{name: 'reviews', params: {id: this.doctorId}}"><input type="button" value="See Reviews"></router-link>
        <router-link :to="{name: 'add-review'}"><input type="button" value="Add a Review"></router-link>
        <router-link v-if="isAuthorized" :to="{name: 'appointment-page', params: {id: this.doctorId}}"><input type="button" value="Schedule an appointment!"></router-link>
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
      this.getDoctorInformation()
      this.getOffices(this.doctorId);
    },
    data() {
      return {
        doctorId: parseInt(this.doctor.id),
        storedReview: this.review,
      }
    },
    methods: {
      isEmpty(object){
        return Object.keys(object).length == 0;
      },
        getOffices(userId) {
          OfficeService.getOfficesByDoctorId(userId).then((response) => {
            this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
          })
        },
        getReview() {
          ReviewService.getReview(this.doctorId).then((response) => {
            this.$store.commit("SET_ACTIVE_REVIEW", response.data);
            this.storedReview = response.data;
          });
        },
        getDoctorInformation() {
          DoctorService.getDoctor(this.doctorId).then((response) => {
            this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
      });
    }
  },
  computed:{
    isAuthorized(){
      return !this.isEmpty(this.$store.state.user);
    }
  }
}
</script>

<style>
.doctor-card {
  display: flex;
  flex-direction: column;
  border: 1px solid lightgrey;
  border-radius: 10px;
  /* width: 500px; */

  margin: 10px;
  padding: 15px;
}

.doctor-icon {
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
.actions {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  gap: 1em;
}
</style>