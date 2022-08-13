import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    filter: 0,
    doctorChoice: 0,
    doctors: [],
    doctor: {
      userId: 0,
      role: '',
      fullName: '',
      typeOfDoctor: '',
      stars: 0
    },
    officesUserBelongsTo: [],
    doctorsInOffice: [],
    offices: [],
    office: {
      officeId: 0,
      officeName: '',
      address: '',
      phoneNumber: 0,
      officeHoursOpen: '',
      officeHoursClose: '',
      costPerHour: 0,
      officeImageUrl: '',
      delay: false
    },
    notifications: [],
    notification: {
      notificationId: 0,
      userId: '',
      message: '',
      isRead: false
    },
    about: "aboutDetails",
    reviews: [],
    review: {
        reviewId: 0,
        stars: 0,
        message: '',
        doctorId: 0,
        patientId: 0,
        officeId: 0,
        response: ''
    }
  },
  mutations: {
    SET_DOCTORS(state, data) {
      state.doctors = data;
    },
    SET_DOCTOR_CHOICE(state, data) {
      state.doctorChoice = data;
    },
    GET_DOCTORS(state, userId){
      state.doctors = state.doctors.find( (doctor =>{
        return doctor.userId = userId
      }))
    },
    SET_REVIEWS(state, data) {
      state.reviews = data;
    },
    GET_REVIEWS(state, reviewId){
      state.reviews = state.reviews.find( (review =>{
        return review.reviewId = reviewId
      }))
    },
    SET_NOTIFICATIONS(state, data) {
      state.notifications = data;
    },
    CLEAR_NOTIFICATION(state) {
      state.notification = null;
    },
    SET_OFFICES(state, data) {
      state.offices = data;
    },
    UPDATE_FILTER(state, filter) {
      state.filter = filter;
    },
    SET_USER_OFFICES(state, data){
      state.officesUserBelongsTo = data;
    },
    GET_OFFICE(state, officeId){
      state.office = state.offices.find( (office =>{
        return office.officeId = officeId
      }))
    },
    SET_DOCTORS_IN_OFFICE(state, data){
      state.doctorsInOffice = data;
    },
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
