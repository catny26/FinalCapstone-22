import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default{
    getDoctors(){
        return http.get('/doctors');
    },

    getDoctorsInOffice(officeId){
        return http.get(`/doctors/office/${officeId}`);
    },
    
    getDoctor(doctorId) {
        return http.get(`users/${doctorId}`);
    }
}