<template>
  <div>
      <h3>{{user.fullName}}</h3>
    <div>
        <h4> Here are the offices you belong to</h4>
        <div v-for="office in this.$store.state.officesUserBelongsTo" v-bind:key="office.id">
        <office-card v-bind:office="office"/>
    <input type="button" value="Leave Office" @click="leaveOffice(office.officeId)">
        </div>
    </div>

        <p>Select the Offices you wish to join!</p>
        <div v-for="office in officesUserDoesNotBelongTo" :key="office.officeId">
            <label :for="office.officeId">{{office.officeName}}</label>
            <input type="checkbox" :name="office.officeId" :id="office.officeId" :value="office.officeId"  v-model="selectedOffices">
        </div>
        <input type="button" value="Join Offices" @click="joinOffices">

        <p>Add a new office!</p>
        <form action="#" @submit.prevent="addOffice">
        <div class="form-field">
          <label for="office-name">Office Name: </label>
          <input type="text" name="office-name" id="office-name" v-model="newOffice.officeName">
        </div>
        <div class="form-field">
          <label for="office-address">Office Address: </label>
          <input type="text" name="office-address" id="office-address" v-model="newOffice.address">
        </div>
        <div class="form-field">
          <label for="office-phone-number">Phone Number: </label>
          <input type="tel" name="office-phone-number" id="office-phone-number" v-model="newOffice.phoneNumber">
        </div>
        <div class="form-field">
          <label for="office-hours-open">When The Office Opens: </label>
          <input type="time" name="office-hours-open" id="office-hours-open" v-model="newOffice.officeHoursOpen">
        </div>
        <div class="form-field">
          <label for="office-hours-close">When The Office Closes: </label>
          <input type="time" name="office-hours-close" id="office-hours-close" v-model="newOffice.officeHoursClose">
        </div>
        <div class="form-field">
          <label for="office-cost-per-hour">Cost per Hour to See Doctor: </label>
          <input type="number" name="office-cost-per-hour" id="office-cost-per-hour" v-model="newOffice.costPerHour">
        </div>
        <div class="form-field">
          <label for="office-image">URL to picture of Office</label>
          <input type="text" name="office-image" id="office-image" v-model="newOffice.officeImageUrl">
        </div>
        <input type="submit" value="Add New Office">
      </form>
  </div>
</template>

<script>
import OfficeService from '@/services/OfficeService'
import OfficeCard from '@/components/OfficeCard'

export default {
    components:{
        OfficeCard
    },
    data(){
        return {
            user: {},
            officesUserBelongsTo: [],
            selectedOffices: [],
            offices: [],
            newOffice: {
                officeId: 0,
                officeName: '',
                address: '',
                phoneNumber: 0,
                officeHoursOpen: '',
                officeHoursClose: '',
                costPerHour: 0,
                officeImageUrl: '',
                delay: false
            }
        }

    },
    methods:{
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
            OfficeService.leaveOffice(officeId, this.user.id)
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
        joinOffices(){
            this.selectedOffices.forEach( (officeId) =>{
                OfficeService.joinOffice(officeId, this.user.id)
                .then(response=>{
                if(response.status == 201){
                    this.refreshData()
                }
            })
            .catch(error=>{
                if(error.status == 500){
                    alert("invalid data");
                }
            })
            })
        },
        addOffice(){
            OfficeService.createOffice(this.newOffice, this.user.id)
            .then(response=>{
                if(response.status == 201){
                    this.newOffice = {}
                }
            })
            .catch(error=>{
                if(error.status == 500){
                    alert("invalid data");
                }
            })
        },
        officeInArray(array, officeId){
            let output = true;
            array.forEach(element => {
                    if(element.officeId == officeId){
                        output = false;
                    }
                });
            return output;
        }
    },
    computed:{
        officesUserDoesNotBelongTo(){
            return this.offices.filter( (office) =>{
                return this.officeInArray(this.officesUserBelongsTo, office.officeId)
            })
        }
    },
    created(){
        this.refreshData()
        // this.user = this.$store.state.user;
        // this.offices = this.$store.state.offices;
        // this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;

        // if(this.$store.state.offices.length == 0){
        //     OfficeService.getOffices().then(response=>{
        //         this.$store.commit('SET_OFFICES', response.data);
        //         this.offices = this.$store.state.offices;
        //     })
        // }

        // if(this.$store.state.officesUserBelongsTo.length == 0){
        //     OfficeService.getOfficesByDoctorId(this.$store.state.user.id).then(response=>{
        //         this.$store.commit('SET_USER_OFFICES', response.data);
        //         this.officesUserBelongsTo = this.$store.state.officesUserBelongsTo;
        //     })
        // }
    }

}
</script>

<style>

</style>