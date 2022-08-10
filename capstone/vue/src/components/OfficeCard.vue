<template>
  <!-- <div class="office-card">
    <h4>{{ office.officeName }}</h4>
    <p>Address: {{ office.address }}</p>
    <p>Phone Number: {{ office.phoneNumber }}</p>
      <p>Hours: {{ office.officeHoursOpen }} - {{ office.officeHoursClose }}</p>

  </div> -->

  <div class="office-card">
    <img v-if="hasImage" :src="office.image" alt="An image of the current office">
    <img v-else src="../assets/generic_office_image.jpg" alt="A generic image of a doctors office">
    <h4>{{office.officeName}}</h4>
    <p class="address">{{office.address}}</p>
    <p class="hours">Open Hours: {{formattedOfficeHours}}</p>
    <p class="phone-number">{{formattedPhoneNumber}}</p>
    <input type="button" value="Further Details">
  </div>
</template>

<script>
export default {
  name: "office-card",
  props: ["office"],
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
  computed:{
    hasImage(){
      return this.office.image != null;
    },
    formattedPhoneNumber(){
      return "(" + this.office.phoneNumber.substring(0,3) + ")-" + this.office.phoneNumber.substring(3,6) + "-" + this.office.phoneNumber.substring(6);
    },
    formattedOfficeHours(){
      return this.formatTime(this.office.officeHoursOpen.substring(0,5)) + " - " + this.formatTime(this.office.officeHoursClose.substring(0,5));
      //return this.office.officeHoursOpen.substring(0,5) + " - " + this.office.officeHoursClose.substring(0,5);
    }
  }
};
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