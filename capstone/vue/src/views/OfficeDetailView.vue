<template>
  <office-detail :office="this.$store.state.office" />
</template>

<script>
import OfficeDetail from '../components/OfficeDetail.vue'

export default {
    components: {OfficeDetail}

}
</script>

<style>

</style>