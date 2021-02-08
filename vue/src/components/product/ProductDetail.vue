<template>
    <div class="mt-4">
        <b-card
            img-src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
            img-alt="Card image"
            img-left="img-left"
            class="mb-3">
            <b-card-text>
                상품 :
                {{ product.productName }}
            </b-card-text>
            <b-card-text>
                재고 :
                {{product.quantity}}
            </b-card-text>
            <b-card-text>
                가격 :
                {{product.price}}
            </b-card-text>
            <b-card-text>
                상세 설명 :
                {{product.productDetail}}
            </b-card-text>
            <b-card-text>
            </b-card-text>
            <b-button class="m-2" v-b-modal.order-modal>
                주문하기
            </b-button>
            <b-modal id="order-modal" title=주문하기 @ok="orderRegisterHandler(product.productId, product.productName)">
                <b-form-group>
                    <b-form-input v-model="order.count" placeholder="주문수량"></b-form-input>
                </b-form-group>
                <b-form-group>
                    <b-form-input v-model="order.address" placeholder="배송지"></b-form-input>
                </b-form-group>
            </b-modal>
            <b-button @click="productListHandler">목록보기</b-button>
        </b-card>
     </div>
</template>

<script>
import { ProductApi, OrderApi } from '@/api'
import { Product, Order } from '@/model'

export default {
    name : 'product-detail',
    data : function(){
        return {
            product : new Product(),
            order : new Order(),            
        }
    },
    mounted : function(){
        const productId = this.$route.params.id
        ProductApi.find(productId)
        .then(data => this.product = data)
    },
    methods : {
        orderRegisterHandler : function(productId, productName){
            this.makeOrder(productId, productName)
            OrderApi.register(this.order)
            .then(value => {
                console.log(value)
            });
        },
        makeOrder : function(productId, productName){
            this.order.productId = productId;
            this.order.productName = productName;
            this.order.memberId = this.$session.get('LoggedInId')
        },
        productListHandler : function(){
            this.$router.push('/product/list')
        }
    }
}
</script>

<style>

</style>