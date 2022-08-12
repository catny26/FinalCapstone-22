<template>
  <div class="providers">
    <h1>Providers</h1>
    <br>
    <router-link v-bind:to="{name: 'providers-list'}"><button>Our Doctors</button></router-link>
    <providers-list />
    <br>
    <router-link v-bind:to="{name: 'reviews'}"><button>Reviews</button></router-link>
    <reviews-list />
    <br>

    <br>
    <img src="../assets/doctors-mock.jpg" width="600">
    <br>

  </div>
</template>

<script>
import ProvidersList from "@/components/ProvidersList.vue";
import ReviewsList from "@/components/ReviewsList.vue";

export default {
    name: "providers",
    components: {
      ProvidersList,
      ReviewsList
    }
}
</script>

<style>

</style>