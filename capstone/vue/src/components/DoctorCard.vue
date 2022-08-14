<template>
    <div class = "doctor-card">
      <div class="heading">
        <img src="..\assets\dr-mock.jpg" alt="Doctor Photo" class = "doctor-photo">
        <!-- <img src="#" alt = "Stars" class = "stars"/> -->
        <h4>{{doctor.fullName}}, {{doctor.typeOfDoctor}}</h4>
      </div>
      <div class="link">
        <router-link v-bind:to="{name: 'offices'}"><input type="button"  value="Office Information"></router-link>&nbsp;
        <router-link v-bind:to="{name: 'reviews'}"><input type="button" value="See Reviews"></router-link>&nbsp;
        <router-link v-bind:to="{name: 'add-review'}"><input type="button" value="Add a Review"></router-link>
      </div>

    </div>
</template>

<script>
import officeService from '@/services/OfficeService.js'
// import doctorService from '@/services/DoctorService.js'
export default {
    name: "doctor-card",
    props:["doctor"],
    methods: {
        getOffices(userId) {
            officeService.getOfficesByDoctorId(userId).then((response) => {
            this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
            })
        },
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
        },
    computed:{
        hasImage(){
          return this.office.officeImageUrl != null && this.office.officeImageUrl != '';
        },
        formattedPhoneNumber(){
          return "(" + this.office.phoneNumber.toString().substring(0,3) + ")-" + this.office.phoneNumber.toString().substring(3,6) + "-" + this.office.phoneNumber.toString().substring(6);
        },
        formattedOfficeHours(){
          return this.formatTime(this.office.officeHoursOpen.substring(0,5)) + " - " + this.formatTime(this.office.officeHoursClose.substring(0,5));
          //return this.office.officeHoursOpen.substring(0,5) + " - " + this.office.officeHoursClose.substring(0,5);
        }
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

.doctor-card img{
  display: block;
  border: 2px solid black;
  border-radius: 10px;

  width: 80px;
  height: 80px;
}

.doctor-card h4 {
  grid-area: "name";
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