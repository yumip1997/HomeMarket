import  { DefaultView }  from '@/views'
import { MemberRegister, Login } from '@/components'

import VueRouter from 'vue-router'

const routes = [
    {path : '/', component : DefaultView},
    {path : '/member/register', component : MemberRegister},
    {path : '/login', component : Login},
]

export default new VueRouter({
    routes
});