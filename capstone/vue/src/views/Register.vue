<template>
  <div id="register" class="form-group">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-group">
        <label for="username" class="sr-only">Username</label>
      </div>
      <div class="form-group">
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-group">
        <label for="full_name" class="sr-only">Full Name</label>
      </div>
      <div class="form-group">
        <input
          type="text"
          id="full_name"
          class="form-control"
          placeholder="Full Name"
          v-model="user.fullName"
          required
        />
      </div>
      <div class="form-group">
        <label for="password" class="sr-only">Password</label>
      </div>
      <div class="form-group">
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <div class="form-group">
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <div class="form-group">
        <div class="roleselect">
            <b-form-radio
              v-model="user.role"
              :aria-describedby="ariaDescribedby"
              name="some-radios"
              id="userrole"
              value="user"
              >I am a patient</b-form-radio
            >
            <b-form-radio
              v-model="user.role"
              :aria-describedby="ariaDescribedby"
              name="some-radios"
              id="doctorrole"
              value="doctor"
              >I am a doctor</b-form-radio
            >

        </div>
      </div>
      <div class="form-group">
        <router-link :to="{ name: 'login' }">Have an account?</router-link>
      </div>
      <div class="form-group">
        <button class="btn btn-lg btn-primary btn-block" type="submit">
          Create Account
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        fullName: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              if(this.user.role == 'doctor'){
                this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
              }
              else{
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
              }
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
              console.log("username " + this.user.username);
              console.log("password " + this.user.password);
              console.log("confirmPassword " + this.user.confirmPassword);
              console.log("fullName " + this.user.fullName);
              console.log("role " + this.user.role);
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style>
#register {
  text-align: left;
  margin: auto;
  display: flex;
  align-items: center;
}

.form-register {
  margin: auto;
}


.radio-buttons {
  margin: 0px;
  padding: 0px;
}
#userrole {
  margin-right: 8px;
  margin-bottom: 8px;
}

#doctorrole {
  margin-right: 8px;
}
</style>
