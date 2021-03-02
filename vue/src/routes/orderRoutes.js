import { OrderView } from '@/views'
import { OrderList, SellingProductOrderList } from '@/components'

const orderRoutes = [
    {
        path : '/order',
        component : OrderView,
        children : [
            {
                path : 'list',
                component : OrderList
            },
            {
                path : 'sellingProductOrderList',
                component : SellingProductOrderList
            }
        ]
    }
]

export default orderRoutes;