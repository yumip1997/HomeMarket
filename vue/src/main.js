import Vue from 'vue'

import App from './App.vue'

import VueSession from 'vue-session'
import VueMoment from 'vue-moment'

import VueRouter from 'vue-router'
import routes from './routes.js'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

var sessionOptions = {
  persist: true
}

Vue.use(VueSession, sessionOptions)
Vue.use(VueSession)

Vue.use(VueMoment)
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
