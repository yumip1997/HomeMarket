import VueRouter from 'vue-router'
import {HomeComponent} from '@/components'
import memberRoutes from './memberRoutes'
import authRoutes from './authRoutes'

export default new VueRouter({
    routes : [{
        path : '/', component : HomeComponent
    },
        ...memberRoutes, 
        ...authRoutes
    ]
});