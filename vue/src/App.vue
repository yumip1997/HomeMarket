<template>
<div>
  <main-header />
  <main-content />
</div>
</template>

<script>
import { MainHeader } from '@/components'
import { MainContent } from '@/components'

export default {
  name: 'App',
  components: {
    MainHeader,
    MainContent
  }
}
</script>
<style>
</style>
