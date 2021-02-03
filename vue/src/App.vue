<template>
  <div>
    <main-header />
    <router-view>
    </router-view>
  </div>
</template>

<script>
import MainHeader from './components/MainHeader.vue'

export default {
  components: { MainHeader },
  name: 'App',
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
