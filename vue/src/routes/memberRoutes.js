import { MemberView } from '@/views'
import { MemberRegister} from '@/components'

const memberRoutes = [
    {
        path : '/member',
        component : MemberView,
        children : [
            {
                path : 'register',
                component : MemberRegister
            }
        ]
    },
];

export default memberRoutes;