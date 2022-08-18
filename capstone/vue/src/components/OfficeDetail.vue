<template>
  <div class="office-detail">
      <h4 class="title">{{office.officeName}}</h4>
      <img class="office-image-detail" v-if="hasImage" :src="office.officeImageUrl" alt="An image of the current office">
      <img v-else src="#" alt="A generic image of a doctors office">
      
      <p class="address">{{office.address}}</p>
      <p class="hours">Open Hours: {{formattedOfficeHours}}</p>
      <p class="phone-number">{{formattedPhoneNumber}}</p>
      <p class="cost-per-hour">${{office.costPerHour}} per hour</p>

      <!-- <div>
        <h3>Our Doctors</h3>
        <doctor-card v-for="doctor in doctors" :key="doctor.id" :doctor="doctor" />
      </div> -->

      <div class="actions">
      <router-link :to="{name: 'offices'}"><input type="button" value="Back"></router-link>&nbsp;
      <input type="button" value="Edit Office Info" @click="editOfficeInfo = !editOfficeInfo" v-if="worksHere" >&nbsp;
      <input type="button" :value="office.delay? 'operating on a delay' : 'No Delay'" @click="toggleDelay" :class="{delay: office.delay}" :disabled="!worksHere">
      </div>

      <form v-if="editOfficeInfo" action="#" @submit.prevent="updateOfficeInfo">
        <div class="form-field">
          <label for="office-name">Office Name: </label>
          <input type="text" name="office-name" id="office-name" v-model="updatedOffice.officeName">
        </div>
        <div class="form-field">
          <label for="office-address">Office Address: </label>
          <input type="text" name="office-address" id="office-address" v-model="updatedOffice.address">
        </div>
        <div class="form-field">
          <label for="office-phone-number">Phone Number: </label>
          <input type="tel" name="office-phone-number" id="office-phone-number" v-model="updatedOffice.phoneNumber">
        </div>
        <div class="form-field">
          <label for="office-hours-open">When The Office Opens: </label>
          <input type="time" name="office-hours-open" id="office-hours-open" v-model="updatedOffice.officeHoursOpen">
        </div>
        <div class="form-field">
          <label for="office-hours-close">When The Office Closes: </label>
          <input type="time" name="office-hours-close" id="office-hours-close" v-model="updatedOffice.officeHoursClose">
        </div>
        <div class="form-field">
          <label for="office-cost-per-hour">Cost per Hour to See Doctor: </label>
          <input type="number" name="office-cost-per-hour" id="office-cost-per-hour" v-model="updatedOffice.costPerHour">
        </div>
        <div class="form-field" v-if="hasImage">
          <label for="office-image">URL to picture of Office</label>
          <input type="text" name="office-image" id="office-image" v-model="updatedOffice.officeImageUrl">
        </div>
        <input type="submit" value="Update Office Info">
      </form>
    

  </div>
</template>

<script>
// import DoctorCard from '@/components/DoctorCard'
import OfficeService from '@/services/OfficeService'
import DoctorService from '@/services/DoctorService'

export default {
  created(){
      this.$store.commit('GET_OFFICE', this.$route.params.officeId);
      this.offices = this.$store.state.offices;
      this.setActiveOffice();
      if(!this.isEmpty(this.$store.state.user)){
        OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
          this.$store.commit('SET_USER_OFFICES', response.data);
          this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;
        })
      }

      DoctorService.getDoctorsInOffice(this.$route.params.officeId).then(response=>{
        this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
      })
  },
  // components:{DoctorCard},
    data(){
        return {
            offices: [],
            officesUserBelongsTo: [],
            editOfficeInfo: false,
            updatedOffice: {},
            office: {}
        }
    },
    name: "office-detail",
    props: ["doctors"],
    methods: {
      setActiveOffice(){
        this.offices.forEach( (office)=>{
          if(office.officeId == this.$store.state.activeOfficeId){
            this.office = office;
          }
        })
      },
      toggleDelay(){
        this.updatedOffice.delay = !this.updatedOffice.delay
        this.updateOfficeInfo()
      },
      isEmpty(object){
        return Object.keys(object).length ==0;
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
    updateOfficeInfo(){
      OfficeService.updateOfficeInfo(this.updatedOffice)
      .then(response=>{
        if(response.status == 200){
          OfficeService.getOffices().then(responseSecond=>{this.$store.commit('SET_OFFICES', responseSecond.data)})
        }
        this.$store.commit('GET_OFFICE', this.updatedOffice.officeId)
        this.editOfficeInfo = !this.editOfficeInfo;
      })
      .catch((error)=>{
        const response = error.response;

        if(response.status === 500){
          alert("Invalid Data entered, please try again")
          this.updatedOffice = this.office;
        }

      })
    }
  },
  computed:{
    worksHere(){
      if(! this.isEmpty(this.$store.state.user)){
        if(this.$store.state.user.authorities[0].name == 'ROLE_DOCTOR'){
        for(let i = 0; i < this.officesUserBelongsTo.length;i++){
            if(this.officesUserBelongsTo[i].officeId == this.office.officeId){
                return true
            }
        }
        }
    }
        return false;
    },
    hasImage(){
      return this.office.officeImageUrl != null && this.office.officeImageUrl != '';
    },
    formattedPhoneNumber(){
      return "(" + this.office.phoneNumber.toString().substring(0,3) + ")-" + this.office.phoneNumber.toString().substring(3,6) + "-" + this.office.phoneNumber.toString().substring(6);
    },
    formattedOfficeHours(){
      return this.formatTime(this.office.officeHoursOpen.substring(0,5)) + " - " + this.formatTime(this.office.officeHoursClose.substring(0,5));
    }
  }

}
</script>

<style>
.office-detail {
  display: flex;
  flex-direction: column;
  border: 1px solid lightgrey;
  width: 700px;
  background-color: whitesmoke;
  margin: 10px;
  padding: 15px;
  align-items: center;
}

.office-detail img{
  /* grid-area: "office-image"; */
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  height: auto;
}

.office-image-detail {
  width: 80%;
  height: auto;
}

.office-detail h4 {
  /* grid-area: "name"; */
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}

.office-detail p {
  font-size: 1.2vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}


/* .delay{
  background-color: red;
} */

</style>