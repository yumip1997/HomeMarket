import AxiosClient from './AxiosClient';

class PrdouctApi{
    constructor(){
        this.client = new AxiosClient('/product')
    }

    async register(product){
        return this.client.post('/create', product)
    }

    async findByCategories(categories){
        const data = (await this.client.get('/retrieveByCategories',
        {categories : categories})).data
        return data
    }

    async find(productId){
        const data = (await this.client.get('/retrieve',
        {productId : productId})).data
        return data
    }

    async findOrderedProduct(memberId){
        const data = (await this.client.get('/retrieveOrderedProduct',
        {memberId : memberId})).data
        return data
    }
}

const instance = new PrdouctApi();

export default instance;