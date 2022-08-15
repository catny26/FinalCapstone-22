import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {
    getMessages(userId) {
        return http.get(`/notification/${userId}`);
      }
}