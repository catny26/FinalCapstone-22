<template>
    <div class = "doctor-card">

        <div>
        <img src="#" alt="Doctor Photo" class = "doctor-photo"/>
        <img src="#" alt = "Stars" class = "stars"/>
        </div>
        
        <h4>{{doctor.fullName}}, {{doctor.typeOfDoctor}}</h4>

        <!-- <p>{{office.officeName}}</p>
        <p>{{office.address}}</p>
        <p>{{office.phoneNumber}}</p>
        <p>{{office.officeHoursOpen}}</p>
        <p>{{office.officeHoursOpen}}</p> -->

        <router-link v-bind:to="{path: '/offices'}">
            <button class = "office">Office Information</button>
        </router-link>
        <br>
        <router-link v-bind:to="{path: '/reviews'}">
            <button class = "office">Reviews</button>
        </router-link>
    </div>
</template>

<script>
import officeService from '@/services/OfficeService.js'
// import doctorService from '@/services/DoctorService.js'
export default {
    name: "doctor-card",
    props:["doctor", "office"],
    methods: {
        getOffices(userId) {
            officeService.getOfficesByDoctorId(userId).then((response) => {
                this.$store.commit('SET_DOCTORS_IN_OFFICE', response.data)
            })
        }
    }
}
</script>

<style>
.doctor-card {
  display: flex;
  flex-direction: column;
  align-items: center;

  border: 2px solid black;
  border-radius: 10px;
  width: 400px;

  margin: 10px;
  padding: 15px;
}

img.doctor-photo{
  display: block;
  width: 50%;
  height: 50%;
  align-items: center;
}

img.stars{
  display: block;
  width: 50%;
  height: 50%;
  align-items: center;
}

.doctor-card h4 {
  font-size: 1.5vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}

.doctor-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: center;
}

.doctor-card button {
  align-content: center;
}
</style>