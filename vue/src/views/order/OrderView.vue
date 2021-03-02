<template>
  <div>
    <order-menu />
    <router-view />
  </div>
</template>

<script>
import { OrderMenu } from '@/components/order'
export default {
    name : 'OrderView',
    components: {
      OrderMenu
    },
}
</script>

<style>

</style>