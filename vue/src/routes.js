import { DefaultPage } from '@/components'
import { LoginVue } from '@/components'

import { MemberRegister, MyInfo, MemberModify } from '@/components'

import { ProductList, ProductRegister, ProductDetail } from '@/components'

import { OrderList, OrderDetail, OrderedProductList } from '@/components'

const routes = [
    {path : '/', component : DefaultPage},
    {path : '/login', component : LoginVue},
    {path : '/member/register', component : MemberRegister},
    {path : '/member/myInfo', component : MyInfo},
    {path : '/member/modify', component : MemberModify},
    {path : '/product/list', component : ProductList},
    {path : '/product/detail/:id',component : ProductDetail},
    {path : '/product/register', component : ProductRegister},
    {path : '/product/myproduct', component : OrderedProductList},
    {path : '/order/list', component : OrderList},
    {path : '/order/detail/:id', component : OrderDetail},
]

export default routes;