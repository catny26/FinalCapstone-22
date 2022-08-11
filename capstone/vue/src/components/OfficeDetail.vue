<template>
  <div id="office-detail">
      <h2 class="title">{{office.officeName}}</h2>
      <img v-if="hasImage" :src="office.image" alt="An image of the current office">
      <img v-else src="../assets/generic_office_image.jpg" alt="A generic image of a doctors office">

      <router-link :to="{name: 'offices'}"><input type="button" value="Back"></router-link>

  </div>
</template>

<script>
export default {
    name: "office-detail",
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

}
</script>

<style>

</style>