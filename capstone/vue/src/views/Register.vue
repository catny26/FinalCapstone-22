<template>
  <div id="register" >
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div>
      <label for="username" class="sr-only">Username</label>
      </div>
      <div>
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
      <div>
      <label for="password" class="sr-only">Password</label>
       </div>
      <div>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
       </div>
      <div>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
       </div>
      <div>

      <form>
      <input
        type="radio"
        id="userrole"
        class="form-control"
        value="user"
        v-model="user.role"
      />
<label for="doctorrole">I am a patient</label>
      </form><form>
 <input
        type="radio"
        id="doctorrole"
        class="form-control"
        value="doctor"
        v-model="user.role"
        
        
      />
<label for="doctorrole">I am a doctor</label>
</form>
 </div>
      <div>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
       </div>
      <div>
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
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
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
</style>
