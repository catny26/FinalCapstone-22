import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {

  getAgenda(doctorID) {
    return http.get(`/doctors/${doctorID}/agenda`)
  },

  getDaysOff(doctorID) {
    return http.get(`/doctors/offDays/${doctorID}`)
  },


}
