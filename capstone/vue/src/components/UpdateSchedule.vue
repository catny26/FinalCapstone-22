<template>
  <div class="container">
    <div class="main">
      <h1 class="appointment-header">Please update your availability:</h1>
      <table>
        <tr>
          <td class="day">Monday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.monStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.monEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Tuesday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.tueStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.tueEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Wednesday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.wenStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.wenEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Thursday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.thurStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.thurEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Friday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.friStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.friEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Saturday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.satStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.satEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Sunday</td>
          <td>
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.sunStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.sunEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
        <tr>
          <td class="day">Lunch</td>
          <td id="secondCol">
            <div class="start-time">
              <td id="firstCol">
                <label for="starttime">Choose a start time:</label>
              </td>
              <td id="secondCol">
                <select
                  name="starttime"
                  id="starttime"
                  v-model="schedule.lunchStart"
                >
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
            <div class="end-time">
              <td id="firstCol">
                <label for="endtime">Choose an end time:</label>
              </td>
              <td id="secondCol">
                <select name="endtime" id="endtime" v-model="schedule.lunchEnd">
                  <option :value="null" selected>None</option>
                  <option v-for="n in 9" v-bind:key="n">0{{ n }}:00:00</option>
                  <option v-for="n in hours" v-bind:key="n">
                    {{ n }}:00:00
                  </option>
                </select>
              </td>
            </div>
          </td>
        </tr>
      </table>

      <b-button v-on:click="submitNewAgenda" variant="outline-primary"
        >Submit</b-button
      >
    </div>
  </div>
</template>

<script>
import AgendaService from "@/services/AgendaService";

export default {
  created() {},
  name: "update-schedule",
  props: ["doctorID", "agenda"],
  components: {},
  data() {
    return {
      firstColumn: [
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday",
        "Lunch",
      ],
      schedule: {
        monStart: "",
        monEnd: "",
        tueStart: "",
        tueEnd: "",
        wenStart: "",
        wenEnd: "",
        thurStart: "",
        thurEnd: "",
        friStart: "",
        friEnd: "",
        satStart: "",
        satEnd: "",
        sunStart: "",
        sunEnd: "",
        lunchStart: "",
        lunchEnd: "",
      },
      hours: [10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24],
    };
  },
  methods: {
    submitNewAgenda() {
      const newAgenda = {
        doctorId: this.$route.params.id,
        monStart: this.schedule.monStart,
        monEnd: this.schedule.monEnd,
        tueStart: this.schedule.tueStart,
        tueEnd: this.schedule.tueEnd,
        wenStart: this.schedule.wenStart,
        wenEnd: this.schedule.wenEnd,
        thurStart: this.schedule.thurStart,
        thurEnd: this.schedule.thurEnd,
        friStart: this.schedule.friStart,
        friEnd: this.schedule.friEnd,
        satStart: this.schedule.satStart,
        satEnd: this.schedule.satEnd,
        sunStart: this.schedule.sunStart,
        sunEnd: this.schedule.sunEnd,
        lunchStart: this.schedule.lunchStart,
        lunchEnd: this.schedule.lunchEnd,
      };

      AgendaService.postAgenda(newAgenda);
    },
  },
};
</script>

<style>
.container {
  display: flex;
  justify-content: center;
  margin-top: 30px;
}
.main {
  display: flex;
  flex-direction: column;
  background: #f2f2f2;
  border: 1px solid #ddd;
  padding: 2em;
  width: 700px;
}
.day {
  width: 150px;
}
tr {
  outline: thin solid;
}
#firstCol {
  border-left: 1px solid black;
  width: 200px;
  padding-top: 10px;
  padding-bottom: 10px;
}

#secondCol {
  border-left: 1px solid black;
  width: auto;
  padding-left: 10px;
}

#starttime {
  width: 100px;
  border-left: 1px solid black;
}

#starttime option {
  padding: 15px;
  width: 100px;
}

#endtime {
  width: 100px;
  border-left: 1px solid black;
}

#endtime option {
  padding: 15px;
  width: 100px;
}
</style>