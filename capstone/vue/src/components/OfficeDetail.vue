<template>
  <div id="office-detail">
      <h2 class="title">{{office.officeName}}</h2>
      <img v-if="hasImage" :src="office.image" alt="An image of the current office">
      <img v-else src="../assets/generic_office_image.jpg" alt="A generic image of a doctors office">

      <h3 v-if="worksHere">You work here!!</h3>

      <p class="address">{{office.address}}</p>
      <p class="hours">Open Hours: {{formattedOfficeHours}}</p>
      <p class="phone-number">{{formattedPhoneNumber}}</p>
      <p class="cost-per-hour">${{office.costPerHour}} per hour</p>

      <div>
        <doctor-card v-for="doctor in doctors" :key="doctor" :doctor="doctor" />
      </div>

      <router-link :to="{name: 'offices'}"><input type="button" value="Back"></router-link>

  </div>
</template>

<script>
import DoctorCard from '@/components/DoctorCard'
import OfficeService from '@/services/OfficeService'

export default {
  components:{DoctorCard},
    data(){
        return {
            officesUserBelongsTo: [],
        }
    },
    name: "office-detail",
    props: ["office", "doctors"],
    methods: {
    formatTime(time){
      if(parseInt(time.substring(0,2)) > 12){
        time += " pm"
        time = parseInt(time.substring(0,2)%12) + time.substring(2);
        return time;
      }
      else{
        time+= " am";
      }
      if(time[0] == "0"){
        time = time.substring(1);
      }
      return time;
    }
  },
  created(){
    if(this.$store.state.officesUserBelongsTo.length == 0){
      OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
        this.$store.commit('SET_USER_OFFICES', response.data);
        this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;
        this.$store.commit('GET_OFFICE', parseInt(this.$route.params.officeId));
      })
    }
    else {
    this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;
    }
  },
  computed:{
    worksHere(){
        for(let i = 0; i < this.officesUserBelongsTo.length;i++){
            if(this.officesUserBelongsTo[i].officeId == this.office.officeId){
                return true
            }
        }
        return false;
    },
    hasImage(){
      return this.office.image != null;
    },
    formattedPhoneNumber(){
      return "(" + this.office.phoneNumber.substring(0,3) + ")-" + this.office.phoneNumber.substring(3,6) + "-" + this.office.phoneNumber.substring(6);
    },
    formattedOfficeHours(){
      return this.formatTime(this.office.officeHoursOpen.substring(0,5)) + " - " + this.formatTime(this.office.officeHoursClose.substring(0,5));
    }
  }

}
</script>

<style>
.office-card {
  display: grid;
  /* grid-template-areas:
    "office-image office-image . . phone-number",
    "name name . . address",
    "hours hours . . details-button"; */

  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.office-card img{
  grid-area: "office-image";
  display: block;
  width: 50%;
  height: 75%;
}

.office-card h4 {
  grid-area: "name";
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

.office-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

.office-card input {
  grid-area: "details-button";
}

.hours{
  grid-area:"hours";
}

.address{
  grid-area: "address";
}
</style>