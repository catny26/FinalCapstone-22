<template>
  <div class="office-card">
    <h4>{{ office.officeName }}</h4>
    <p>Address: {{ office.address }}</p>
    <p>Phone Number: {{ office.phoneNumber }}</p>
      <p>Hours: {{ office.officeHoursOpen }} - {{ office.officeHoursClose }}</p>

  </div>
</template>

<script>
export default {
  name: "office-card",
  props: ["office"],
  methods: {},
};
</script>

<style>
.office-card {
  border: 2px solid black;
  border-radius: 10px;
  width: 500px;

  margin: 10px;
  padding: 15px;
}

.office-card h4 {
  font-size: 2vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}

.office-card p {
  font-size: 1vw;
  margin: 5px;
  padding: 5px;
  text-align: left;
}
</style>