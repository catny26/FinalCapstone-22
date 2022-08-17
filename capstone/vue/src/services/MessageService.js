import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000",
});

export default {
    getMessages(userId) {
        return http.get(`/notification/user/${userId}`);
      },
    sendMessage(notification) {
        return http.post('/notification/create', notification);
      },
    updateMessage(notificationId, notification) {
        console.log("updating message isRead = " + notification.isRead)
        return http.put(`/notification/update/${notificationId}`, notification);
      }
}