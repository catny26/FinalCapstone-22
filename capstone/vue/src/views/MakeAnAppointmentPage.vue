<template>
<div class="container">
 <div class="main">
     <h3>Please select a doctor: </h3>

     <div class="radio-buttons">
    <b-form-group label="" v-slot="{ ariaDescribedby }">
      <b-form-radio-group
        id="radio-group-1"
        v-model="selected"
        :options="options"
        :aria-describedby="ariaDescribedby"
        name="radio-options"
        style="font-size: 20px; padding: 5px;"
      ></b-form-radio-group>
    </b-form-group>
</div>
        

    <div class="mt-3"><b-button v-on:click="submitDoctorChoice" variant="outline-primary"
              >Next</b-button></div>

  </div>
  </div>
</template>

<script>
import DoctorService from "@/services/DoctorService";

export default {
  created() {
    this.getDoctorList();
  },
  props: [],
  components: {},
  data() {
    return {
      selected: "first",
      options: [],
    };
  },
  methods: {
    getDoctorList() {
      DoctorService.getDoctors().then((response) => {
        this.$store.commit("SET_DOCTORS", response.data);

        this.$store.state.doctors.forEach((doctor) => {
          const option = {
            text: "",
            value: "",
          };
          option.text = doctor.fullName + ", " + doctor.typeOfDoctor;
          option.value = doctor.id;
          this.options.push(option);
        });
      });
    },
    submitDoctorChoice() {
            this.$router.push(`/doctors/${this.selected}/appointments/`);

    },
  },
};
</script>

<style>
.container {
  display: flex;
  justify-content: center;
  margin-top: 30px;
}
.main {
  display: flex;
  flex-direction: column;
  background: #f2f2f2;
  border: 1px solid #ddd;
  padding: 2em;
  width: 700px;
  font-size: 18px;
}


.radio-buttons {
    font-size: 30px;
}

.custom-control-input {
    padding: 5px;
    margin: 10px;
}

#bv-no-focus-ring {
    float: left;
}
</style>