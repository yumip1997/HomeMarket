import AxiosClient from './AxiosClient';

class OrderApi{
    constructor(){
        this.client = new AxiosClient('/order')
    }


    async register(order){
        return this.client.post('/create',order)
    }

    async findAll(memberId){
        const data = (await this.client.get('/retrieveAll',
        {memberId : memberId})).data
        return data
    }

    async find(orderId){
        const data = (await this.client.get('/retrieve',
        {orderId : orderId})).data
        return data
    }

    async modify(order){
        return this.client.put('/update', order);
    }

    async delete(productId, orderId){
        return this.client.delete('/delete', {
            productId : productId,
            orderId : orderId
        });
    }
}

const instance = new OrderApi();

export default instance;