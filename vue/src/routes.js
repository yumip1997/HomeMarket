import MemberRegister from './components/member/MemberRegister'
import DefaultPage from './components/default/DefaultPage'

const routes = [
    {path : '/', component : DefaultPage},
    {path : '/member/register', component : MemberRegister},
]
export default routes;