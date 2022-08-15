import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {

  createAppointment(appointment) {
    return http.post('/appointments/', appointment)
  },

  getDaysOff(doctorID) {
    return http.get(`/doctors/offDays/${doctorID}`)
  },


}
