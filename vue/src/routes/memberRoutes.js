import { MemberView } from '@/views'
import { MemberRegister, MemberDetail } from '@/components'

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
            }
        ]
    },
];

export default memberRoutes;