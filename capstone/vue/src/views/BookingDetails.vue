<template>
  <div class="example">
    <h3>Dr. Crook's Availability:</h3>
    <div class="calendar">
    <datepicker
      :inline="true"
      v-model="date"
      :disabled-dates="state.disabledDates"
    ></datepicker>
</div>
    <div class="selected-date">Selected Date: {{ date === null ? "None selected" : date }}</div>
  </div>
</template>

<script>
import Datepicker from "vuejs-datepicker/dist/vuejs-datepicker.esm.js";
var state = {
  disabledDates: {
    to: new Date(), // Disable all dates up to today 
    // from: new Date(2016, 0, 26), // Disable all dates after specific date
    // days: [6, 0], // Disable Saturday's and Sunday's
    // daysOfMonth: [29, 30, 31], // Disable 29th, 30th and 31st of each month
    dates: [new Date("2022-08-19T03:24:00"), new Date("2022-08-23T03:24:00")],
    ranges: [{ // Disable dates in given ranges (exclusive).
      from: new Date("2022-09-05T03:24:00"),
      to: new Date("2022-09-07T03:24:00")
    }, {
      from: new Date("2022-09-03T03:24:00"),
      to: new Date("2022-09-05T03:24:00")
    }],
    // // a custom function that returns true if the date is disabled
    // // this can be used for wiring you own logic to disable a date if none
    // // of the above conditions serve your purpose
    // // this function should accept a date and return true if is disabled
    // customPredictor: function(date) {
    //   // disables the date if it is a multiple of 5
    //   if(date.getDate() % 5 == 0){
    //     return true
    //   }
    // }
  },
};
export default {
  name: "requesting-appointment-page",

  components: {
    Datepicker,
  },
  data() {
    return {
      date: null,
      format: "d MMMM yyyy",
      disabled: {},
      disabledFn: {
        customPredictor(date) {
          if (date.getDate() % 3 === 0) {
            return true;
          }
        },
      },
      highlightedFn: {
        customPredictor(date) {
          if (date.getDate() % 4 === 0) {
            return true;
          }
        },
      },
      highlighted: {},
      eventMsg: null,
      state: state,
      vModelExample: null,
      changedMonthLog: [],
    };
  },
  methods: {
    highlightTo(val) {
      if (typeof this.highlighted.to === "undefined") {
        this.highlighted = {
          to: null,
          daysOfMonth: this.highlighted.daysOfMonth,
          from: this.highlighted.from,
        };
      }
      this.highlighted.to = val;
    },
    highlightFrom(val) {
      if (typeof this.highlighted.from === "undefined") {
        this.highlighted = {
          to: this.highlighted.to,
          daysOfMonth: this.highlighted.daysOfMonth,
          from: null,
        };
      }
      this.highlighted.from = val;
    },
    setHighlightedDays(elem) {
      if (elem.target.value === "undefined") {
        return;
      }
      let highlightedDays = elem.target.value
        .split(",")
        .map((day) => parseInt(day));
      this.highlighted = {
        from: this.highlighted.from,
        to: this.highlighted.to,
        daysOfMonth: highlightedDays,
      };
    },
    setDisabledDays(elem) {
      if (elem.target.value === "undefined") {
        return;
      }
      let disabledDays = elem.target.value
        .split(",")
        .map((day) => parseInt(day));
      this.disabledDates = {
        from: this.disabledDates.from,
        to: this.disabledDates.to,
        daysOfMonth: disabledDays,
      };
    },
    disableTo(val) {
      if (typeof this.disabled.to === "undefined") {
        this.disabledDates = {
          to: null,
          daysOfMonth: this.disabledDates.daysOfMonth,
          from: this.disabled.from,
        };
      }
      this.disabledDates.to = val;
    },
    disableFrom(val) {
      if (typeof this.disabledDates.from === "undefined") {
        this.disabled = {
          to: this.disabledDates.to,
          daysOfMonth: this.disabled.daysOfMonth,
          from: null,
        };
      }
      this.disabledDates.from = val;
    },
    openPicker() {
      this.$refs.programaticOpen.showCalendar();
    },
    logChangedMonth(date) {
      this.changedMonthLog.push(date);
    },
  },
};
</script>

<style>
body {
  font-family: "Helvetica Neue Light", Helvetica, sans-serif;
  padding: 1em 2em 2em;
}
input,
select {
  padding: 0.75em 0.5em;
  font-size: 100%;
  border: 1px solid #ccc;
  width: 100%;
}

select {
  height: 2.5em;
}

.example {
  background: #f2f2f2;
  border: 1px solid #ddd;
  padding: 0em 1em 1em 1em;
  margin-bottom: 2em;
  width: 600px;
  display:flex;
  flex-direction:column;
}
.calendar {
  padding: 1em;
  align-self: center;
}

code,
pre {
  margin: 1em 0;
  padding: 1em;
  border: 1px solid #bbb;
  display: block;
  background: #ddd;
  border-radius: 3px;
}

.settings {
  margin: 2em 0;
  border-top: 1px solid #bbb;
  background: #eee;
}

h5 {
  font-size: 100%;
  padding: 0;
}

.form-group {
  margin-bottom: 1em;
}

.form-group label {
  font-size: 80%;
  display: block;
}
</style>