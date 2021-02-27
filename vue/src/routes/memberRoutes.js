import { MemberView } from '@/views'
import { MemberRegister, MemberDetail, MemberModify } from '@/components'

const memberRoutes = [
    {
        path : '/member',
        component : MemberView,
        children : [
            {
                path : 'register',
                component : MemberRegister
            },
            {
                path : 'detail',
                component : MemberDetail
            },
            {
                path : 'modify',
                component : MemberModify
            },
        ]
    },
];

export default memberRoutes;