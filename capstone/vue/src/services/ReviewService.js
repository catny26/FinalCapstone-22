import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default{
    getReviews(){
        return http.get('/reviews');
    },

    getReview(reviewId) { 
        return http.get(`/reviews/${reviewId}`);
    },

    getReviewsByDoctorId(id){
        return http.get(`/reviews/doctor/${id}`);
    },

    getReviewsByPatientId(patientId){
        return http.get(`/reviews/patient/${patientId}`);
    },

    createReview(review){
        return http.post('/reviews/add', review);
    },

    updateReview(reviewId, review){
        return http.put(`/reviews/update/${reviewId}`, review)
    },

    respondToReview(id, review){
        return http.put(`/reviews/${id}`, review)
    }
}