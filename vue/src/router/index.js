import VueRouter from 'vue-router'
import DefaultPage from '../components/DefaultPage'
import RegisterMemberPage from '../components/member/RegisterPage'
import MyInfoPage from '../components/member/MyInfoPage'

const routes = [
    { path : '/', component : DefaultPage},
    { path : '/member/register', component : RegisterMemberPage},
    { path : '/member/myInfo', component :MyInfoPage },
]

export default new VueRouter({
    routes
})