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
  },
  
  updateOfficeInfo(officeInfo){
    return http.put('/offices/', officeInfo)
  },

  leaveOffice(officeId, userId){
    return http.delete(`/offices/${officeId}/user/${userId}`)
  },

  joinOffice(officeId, userId){
    return http.put(`/offices/${officeId}/user/${userId}`)
  },

  createOffice(office, userId){
    return http.post(`/offices/${userId}`, office);
  }
}
