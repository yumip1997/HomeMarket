import Vue from 'vue'
import App from './App.vue'

import VueRouter from 'vue-router'
import router from './router/index.js'

import VueMoment from 'vue-moment'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

Vue.use(VueRouter)
Vue.use(VueMoment)
Vue.use(BootstrapVue)

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
