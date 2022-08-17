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

  getAppointments(id, isDoctor){
    if(isDoctor){
      return http.get(`doctors/${id}/appointments`)
    }
    else{
      return http.get(`patients/${id}/appointments`)
    }
  },
  getAppointmentsByPatient(patientID) {
    return http.get(`/patients/appointments/${patientID}`)
  },

  getAppointmentsByDoctor(doctorID) {
    return http.get(`/doctors/appointments/${doctorID}`)
  },

  createMessage(userId) {
    let success
    if (userId.appointment) {
      success = "true"
      return http.post('/notification', userId, {params: { success }})
    }
  },

  updateAppointment(id) {
    return http.put(`/appointment/${id}`, id);
  }

}
