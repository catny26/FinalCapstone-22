import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default{
    getReviews(){
        return http.get('/reviews');
    },

    getReview(id) {
        return http.get(`/reviews/${id}`);
    },

    getReviewsByDoctorId(doctorId){
        return http.get(`/reviews/doctor/${doctorId}`);
    },

    getReviewsByPatientId(patientId){
        return http.get(`/reviews/patient/${patientId}`);
    },

    createReview(review){
        return http.post('/reviews/add', review);
    },

    updateReview(id, review){
        return http.put(`/reviews/update/${id}`, review)
    },

    respondToReview(id, review){
        return http.put(`/reviews/response/${id}`, review)
    }
}