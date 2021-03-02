import { OrderView } from '@/views'
import { OrderList } from '@/components'

const orderRoutes = [
    {
        path : '/order',
        component : OrderView,
        children : [
            {
                path : 'list',
                component : OrderList
            }
        ]
    }
]

export default orderRoutes;