<template>
  <div>
    <main-header />
    <router-view>
    </router-view>
  </div>
</template>

<script>
import MainHeader from './components/shared/MainHeader';

export default {
  name: 'App',
  components: {
    MainHeader,
  }
}
</script>

<style>

</style>
