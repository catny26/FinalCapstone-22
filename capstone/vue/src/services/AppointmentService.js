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
    return http.get(`/patients/${patientID}/appointments`)
  },

  getAppointmentsByDoctor(doctorID) {
    return http.get(`/doctors/${doctorID}/appointments`)
  },

}
