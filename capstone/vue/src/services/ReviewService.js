import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default{
    getReviews(){
        return http.get('/reviews');
    },

    getReviewsByDoctorId(doctorId){
        return http.get(`/reviews/${doctorId}`);
    },

    createReview(){
        return http.post('/reviews');
    },

    updateReview(reviewId){
        return http.put(`/reviews/${reviewId}`)
    },

    respondToReview(reviewId){
        return http.put(`/reviews/${reviewId}`)
    }
}