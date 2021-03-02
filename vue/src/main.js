import Vue from 'vue'
import VueRouter from 'vue-router'
import VueSession from 'vue-session'
import Vuex from 'vuex'
import router from './routes/routes'
import store from './stores/store'

import App from './App.vue'

import SuiVue from 'semantic-ui-vue'
import 'semantic-ui-css/semantic.min.css'

import VCalendar from 'v-calendar'

var sessionOptions = {
  persist : true
};

Vue.config.productionTip = false;

Vue.use(VueRouter);
Vue.use(VueSession, sessionOptions);
Vue.use(VueSession);
Vue.use(Vuex);
Vue.use(SuiVue);
Vue.use(VCalendar);

new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
