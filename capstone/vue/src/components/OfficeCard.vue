<template>
  <div class="office-card">
    <img id="office-image-list" v-if="hasImage" :src="office.officeImageUrl" alt="An image of the current office">
    <img v-else src="#" alt="A generic image of a doctors office">
    <h4>{{office.officeName}}</h4>
    <p class="address">{{office.address}}</p>
    <p class="hours">Open Hours: {{formattedOfficeHours}}</p>
    <p class="phone-number">{{formattedPhoneNumber}}</p>
    <router-link :to="{name: 'office-details', params: {officeId: office.officeId}}"><input @click="setInfo(office.officeId)" type="button" value="Further Details"> </router-link>
    <input type="button" value="Leave Office" v-if="leaveOfficeBtn" @click="leaveOffice(office.officeId)">
  </div>
</template>

<script>
import DoctorService from '@/services/DoctorService'
import OfficeService from '@/services/OfficeService'

export default {
  name: "office-card",
  props: ["office", "leaveOfficeBtn"],
  methods: {
    refreshData(){
            this.user = this.$store.state.user;

                OfficeService.getOffices().then(response=>{
                    this.$store.commit('SET_OFFICES', response.data);
                    this.offices = this.$store.state.offices;
                })

                OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
                    this.$store.commit('SET_USER_OFFICES', response.data);
                    this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;
                })
        },
    leaveOffice(officeId){
            OfficeService.leaveOffice(officeId, this.$store.state.user.id)
            .then(response=>{
                if(response.status == 202){
                    this.refreshData()
                }
            })
            .catch(error=>{
                if(error.status == 500){
                    alert("invalid data");
                }
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
    setInfo(officeId){
      this.$store.commit('UPDATE_ACTIVE_OFFICE', officeId);
      this.$store.commit('GET_OFFICE', officeId);
      DoctorService.getDoctorsInOffice(officeId).then(response=>{
        this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
      })
    }
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
};
</script>

<style>
.office-card {
  display: flex;
  flex-direction: column;
  border: 1px solid lightgrey;
  width: 700px;
  background-color: whitesmoke;
  margin: 10px;
  padding: 15px;
}

.office-card img{
  display: block;
  width: 100%;
  height: auto;
}

.office-card h4 {
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

.office-card p {
  font-size: 1.2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}
</style>