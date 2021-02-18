import Vue from 'vue'
import Vuex from 'vuex'

import memberStore  from './modules/memberStore'

Vue.use(Vuex);

const store = new Vuex.Store({
    modules : {
        memberStore : memberStore
    }
})

export default store