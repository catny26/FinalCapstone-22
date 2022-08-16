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
    patient: {
      id: 0,
      username: '',
      typeOfDoctor: '',
      fullName: ''
    },
    doctors: [],
    doctor: {
      id: 0,
      fullName: '',
      typeOfDoctor: ''
    },
    officesUserBelongsTo: [],
    doctorsInOffice: [],
    offices: [],
    activeOfficeId: 0,
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
    activeAgenda: {
      agendaId: 0,
      doctorId: 0,
      monStart: '',
      monEnd: '',
      tueStart: '',
      tueEnd: '',
      wenStart: '',
      wenEnd: '',
      thurStart: '',
      thurEnd: '',
      friStart: '',
      friEnd: '',
      satStart: '',
      satEnd: '',
      sunStart: '',
      sunEnd: '',
      lunchStart: '',
      lunchEnd: '',
    },
    disabledDates: [],
    dayScheduleArray: [],
    eveningScheduleArray: [],
    activeDate: '',
    activeHour: 0,
    activeStringTimeStart: '',
    activeStringTimeEnd: '',
    activeStringDate: '',
    activeConfirmation: '',
    activeReview: 0,
    reviews: [],
    review: {
      reviewId: 0,
      amountOfStars: 0,
      reviewMessage: '',
      doctorId: '',
      patientId: '',
      officeId: '',
      reviewResponse: ''
    },
    appts: [],
    appointment: {
      id: 0,
      patientId: 0,
      doctorId: 0,
      agendaId: 0,
      startTime: '',
      endTime: '',
      date: '',
      status: '',
      reason: '',
    }
  },
  mutations: {
    SET_DOCTORS(state, data) {
      state.doctors = data;
    },
    GET_DOCTORS(state, userId){
      state.doctors = state.doctors.find( (doctor =>{
        return doctor.userId = userId
      }))
    },
    SET_REVIEWS(state, data) {
      state.reviews = data;
    },
    SET_ACTIVE_REVIEW(state, data) {
      state.activeReview = data;
    },
    SET_ACTIVE_DOCTOR_REVIEW(state, data) {
      state.activeDoctorReview = data;
    },
    GET_REVIEW(state, reviewId){
      state.reviews = state.reviews.find( (review =>{
        return review.reviewId = reviewId
      }))
    },
    SET_NOTIFICATIONS(state, data) {
      state.notifications = data;
    },
    SET_ACTIVE_NOTIFICATION(state, data) {
      state.notification = data;
    },
    GET_NOTIFICATIONS(state, notificationId) {
      state.notifications = state.notifications.find((notification => {
        return notification.notificationId = notificationId
      }))
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
    UPDATE_ACTIVE_OFFICE(state, officeId){
      state.activeOfficeId = officeId;
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
    },
    SET_DISABLED_DATES(state, data) {
      state.disabledDates = data;
    },
    SET_ACTIVE_DOCTOR(state, data) {
      state.doctor = data;
    },
    SET_ACTIVE_AGENDA(state, data) {
      state.activeAgenda = data;
    },
    SET_ACTIVE_DAY_SCHED(state, data) {
      state.dayScheduleArray = data;
    },
    SET_ACTIVE_EVE_SCHED(state, data) {
      state.eveningScheduleArray = data;
    },
    SET_ACTIVE_HOUR(state, data) {
      state.activeHour = data;
    },
    SET_ACTIVE_DATE(state, data) {
      state.activeDate = data;
    },
    SET_ACTIVE_STRING_TIME_START(state, data) {
      state.activeStringTimeStart = data;
    },
    SET_ACTIVE_STRING_TIME_END(state, data) {
      state.activeStringTimeEnd = data;
    },
    SET_ACTIVE_STRING_DATE(state, data) {
      state.activeStringDate = data;
    },
    SET_ACTIVE_CONFIRM(state, data) {
      state.activeConfirmation = data;
    },
    SET_ACTIVE_APPTS(state, data) {
      state.appts = data;
    },
    SET_ACTIVE_PATIENT(state, data) {
      state.patient = data;
    }
  }
})
