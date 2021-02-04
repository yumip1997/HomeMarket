import DefaultPage from './components/default/DefaultPage'
import LoginVue from './components/shared/LoginVue'
import MemberRegister from './components/member/MemberRegister'
import MyInfo from './components/member/MyInfo'
import MemberModify from './components/member/MemberModify'

import ProductList from './components/product/ProductList'

const routes = [
    {path : '/', component : DefaultPage},
    {path : '/login', component : LoginVue},
    {path : '/member/register', component : MemberRegister},
    {path : '/member/myInfo', component : MyInfo},
    {path : '/member/modify', component : MemberModify},
    {path : '/product/list', component : ProductList},
]

export default routes;