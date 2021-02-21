<template>
<div>
  <main-header-view />
  <main-content-view />
</div>
</template>

<script>
import { MainHeaderView } from '@/views'
import { MainContentView } from '@/views' 

export default {
  name: 'App',
  components: {
    MainHeaderView,
    MainContentView,
  }
}
</script>
<style>
</style>
