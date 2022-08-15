<template>
  <schedule :userId="this.$store.state.user.id"/>
</template>

<script>
import Schedule from '@/components/Schedule'

export default {
    components: {Schedule}

}
</script>

<style>

</style>