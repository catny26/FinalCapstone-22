<template>
  <div class = "portal">
      <h1>Welcome To Your Portal</h1>
      <patient-portal></patient-portal>

  </div>
</template>

<script>
import PatientPortal from '@/components/PatientPortal'
export default {
    name: "patient-portal",
    components: {
        PatientPortal,
    }
}
</script>

<style>
/* .portal {
  display: grid;
  grid-template-rows: repeat(3, 1fr);
  align-items: flex-end;
  gap: 20px;
} */
</style>