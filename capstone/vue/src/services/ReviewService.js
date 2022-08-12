import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default{
    getReviews(){
        return http.get('/providers/reviews');
    },

    getReviewsByDoctor(userId){
        return http.get(`/providers/reviews/${userId}`);
    },

    updateReview(reviewId){
        return http.put('/reviews/', reviewId)
    }
}