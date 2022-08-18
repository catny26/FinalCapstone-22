<template>
  <div class="office-detail-view">
  <office-detail :doctors="this.$store.state.doctorsInOffice"/>
  </div>
</template>

<script>
import OfficeDetail from '../components/OfficeDetail.vue'

export default {
    components: {OfficeDetail}

}
</script>

<style>
.office-detail-view {
  display: flex;
  flex-direction: column;
  align-items: center;
  flex-wrap: wrap;
}
</style>