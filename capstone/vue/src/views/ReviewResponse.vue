<template>
  <div class="review-response">
      <review-card v-bind="getReviewById" />

        <form v-on:submit.prevent="respondToReview">

        </form>

  </div>
</template>

<script>
import ReviewService from '@/services/ReviewService.js'
import ReviewCard from '@/components/ReviewCard.vue'

export default {
    name: 'review-response',
    components: {
        ReviewCard
    },
    create() {
        this.getReviewById
    },
    data() {
        return {
            id: parseInt(this.id)
        }
    },
    method: {
        getReviewById() {
            ReviewService.getReview(this.id).then((response) => {
                this.store.commit('SET_ACTIVE_REVIEW', response.data)

            })
        }
    }
}
</script>

<style>

</style>