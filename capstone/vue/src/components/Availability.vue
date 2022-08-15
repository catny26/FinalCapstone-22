<template>
  <div>
    <availability-viewer />
    <button @click="editAvailability = !editAvailability">Edit Availability</button>
    <availability-editor v-if="editAvailability"/>
  </div>
</template>

<script>
import AvailabilityEditor from '@/components/AvailabilityEditor.vue'
import availabilityViewer from '@/components/AvailabilityViewer.vue'
export default {
  components: { AvailabilityEditor, availabilityViewer },
  data(){
    return{
      editAvailability: false
    }
  },
  methods:{

  }

}
</script>

<style>

</style>