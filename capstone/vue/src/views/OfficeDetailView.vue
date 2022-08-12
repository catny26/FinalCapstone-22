<template>
  <office-detail :office="this.$store.state.office" :doctors="this.$store.state.doctorsInOffice"/>
</template>

<script>
import OfficeDetail from '../components/OfficeDetail.vue'

export default {
    components: {OfficeDetail}

}
</script>

<style>

</style>