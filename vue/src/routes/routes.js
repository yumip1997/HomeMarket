import VueRouter from 'vue-router'
import memberRoutes from './memberRoutes'
import authRoutes from './authRoutes'

export default new VueRouter({
    routes : [
        ...memberRoutes, 
        ...authRoutes
    ]
});