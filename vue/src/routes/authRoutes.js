import { AuthView }  from '@/views'
import { SignIn } from '@/components'

const authRoutes = [
    {
        path : '/auth',
        component : AuthView,
        children : [
            {
                path : 'signIn',
                component : SignIn
            }
        ]
    }
];

export default authRoutes;