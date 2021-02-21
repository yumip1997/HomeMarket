import Vue from 'vue'
import Vuex from 'vuex'

import memberStore  from './modules/memberStore'
import authStore from './modules/authStore'
Vue.use(Vuex);

const store = new Vuex.Store({
    modules : {
        authStore : authStore,
        memberStore : memberStore
    }
})

export default store