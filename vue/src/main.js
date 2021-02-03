import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'

import routes from './routes.js';

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false
Vue.use(VueRouter)

Vue.use(BootstrapVue)

const router = new VueRouter({
  routes,
  mode : 'history'
})

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
