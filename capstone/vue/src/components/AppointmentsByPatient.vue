<template>
  <div class="container">

      <h5>Appointment details</h5>
      <table>
        <tr>
          <td>Meeting with</td>
          <td>{{doctorName}}</td>
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
    },
  name: "appointments-by-patient",
  props: ["patientID", "appt"],
  components: {},
  data() {
    return {
      pID: this.patientID,
      appointment: this.appt,
      doctorName: '',
    };
  },
  methods: {
    getDoctorInfo() {
        DoctorService.getDoctor(this.appointment.doctorId).then((response) => {
        this.$store.commit("SET_ACTIVE_DOCTOR", response.data);
        this.doctorName = this.$store.state.doctor.fullName;
        })
    },
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