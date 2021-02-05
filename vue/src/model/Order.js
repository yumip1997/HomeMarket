class Order{
    constructor(orderId, productId, productName, count, state, address, memberId, orderDate){
        this.orderId = orderId,
        this.productId = productId,
        this.productName = productName,
        this.count = count,
        this.state = state,
        this.address = address,
        this.memberId = memberId,
        this.orderDate = orderDate
    }
}

export default Order;