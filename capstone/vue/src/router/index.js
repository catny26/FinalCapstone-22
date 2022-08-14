import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Offices from '@/views/Offices.vue'
import Providers from '@/views/Providers.vue'
import UserResources from '@/views/UserResources.vue'
import BookingDetails from '@/views/BookingDetails.vue'
import About from '@/views/About.vue'
// import Portal from '@/views/Portal.vue'
import Reviews from '@/views/Reviews.vue'
import AddReview from '@/views/AddReview.vue'
import OfficeDetailView from '@/views/OfficeDetailView.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/offices',
      name: 'offices',
      component: Offices,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/offices/:officeId',
      name: 'office-details',
      component: OfficeDetailView,
      meta: {
        requires: false
      }
    },
    {
      path: '/doctors',
      name: 'providers',
      component: Providers,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/patients',
      name: 'patient-resources',
      component: UserResources,
      meta: {
        requiresAuth: false
        //change to true later when user needs to login to see specific portal details
      }
    },
    {
      path: '/doctors/:id/appointments',
      name: 'appointment-page',
      component: BookingDetails,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: '/portal',
    //   name: 'portal',
    //   component: Portal,
    //   meta: {
    //     requiresAuth: true
    //   }

    // },
    {
      path: '/reviews',
      name: 'reviews',
      component: Reviews,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/reviews/add',
      name: 'add-review',
      component: AddReview,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
