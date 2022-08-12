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
      officeImageUrl: ''
    },
    notifications: [],
    notification: {
      notificationId: "",
      user: '',
      message: '',
      isRead: false
    },
    about: "aboutDetails"
  },
  mutations: {
    SET_NOTIFICATION(state, data) {
      state.notification = data;
    },
    CLEAR_NOTIFICATION(state) {
      state.notification = null;
    },
    SET_OFFICES(state, data) {
      state.offices = data;
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
