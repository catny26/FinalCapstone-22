<template>
  <div class="container">

      <h5>Appointment details</h5>
      <table>
        <tr>
          <td>Appointment with</td>
          <td>{{patientName}}</td>
        </tr>
        <tr>
          <td>Date</td>
          <td>{{appointment.date}}</td>
        </tr><tr>
          <td>Time</td>
          <td> {{appointment.startTime}} - {{appointment.endTime}}</td>
        </tr>
        <tr>
          <td>Status:</td>
          <td>{{appointment.status}}</td>
        </tr>
      </table>

  </div>
</template>

<script>
import DoctorService from '@/services/DoctorService'

export default {
    created() {
        this.getDoctorInfo();
        this.getPatientInfo();
    },
  name: "appointments-by-doctor",
  props: ["appt"],
  components: {},
  data() {
    return {
      appointment: this.appt,
      doctor: {
        doctorId: 0,
        fullName: "",
        typeOfDoctor: "",
        amountOfStars: 0,
      },
      patientName: '',
    };
  },
  methods: {
    getDoctorInfo() {
        DoctorService.getDoctor(this.appointment.doctorId).then((response) => {
        this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
        })
    },
    getPatientInfo() {
        DoctorService.getPatientInfo(this.appointment.patientId).then((response) => {
            this.$store.commit("SET_ACTIVE_PATIENT", response.data)
            this.patientName = this.$store.state.patient.fullName;
        })
        
    }
  },
};
</script>

<style>
.container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    width: 50%;
    flex-shrink: 0;
}



table {
    width: 400px;
    text-align: left;
}

table td {
    padding-top: 8px;
    padding-bottom: 8px;
    padding-right: 20px;
    padding-left: 10px;
}
</style>