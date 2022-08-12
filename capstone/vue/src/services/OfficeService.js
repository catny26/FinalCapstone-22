import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {

  getOffices() {
    return http.get('/offices');
  },

  getOfficesById(officeID) {
    return http.get(`/offices/${officeID}`)
  },

  getOfficesByDoctorId(doctorId){
    return http.get(`/doctors/offices/${doctorId}`);
  }
}
