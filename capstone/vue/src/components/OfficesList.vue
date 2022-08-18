<template>
  <div class="offices-list">
      <office-card v-for="office in this.$store.state.offices" v-bind:key="office.id" 
    v-bind:office="office" :leaveOfficeBtn="false"/>

  </div>


</template>

<script>
import OfficeCard from '@/components/OfficeCard';
import officeService from '@/services/OfficeService';

export default {
    name: 'offices-list',
    components: {
        OfficeCard
    },
    created() {
      this.retrieveOffices();
    },
    methods: {
      retrieveOffices(){
        officeService.getOffices().then(response => {
          this.$store.commit("SET_OFFICES", response.data)
        })
      }
    },
}
</script>

<style>
.offices-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>