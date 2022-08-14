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
    
    getDoctor(doctorID) {
        return http.get(`users/${doctorID}`);
    }
}