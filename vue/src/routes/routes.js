import VueRouter from 'vue-router'
import {MemberRegisterView, SignInView} from '@/views'

const routes = [
    {
        path : '/memberRegister', 
        name: 'memberRegister', 
        component : MemberRegisterView
    },
    {
        path : '/signIn',
        name : 'signIn', 
        component : SignInView
    }
]

export default new VueRouter({
    routes
});