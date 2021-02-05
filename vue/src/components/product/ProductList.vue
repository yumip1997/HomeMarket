<template>
    <div>
        <div id="productList">
            <b-card title="상품 리스트" body-class="text-center" header-tag="nav">
                <template #header>
                    <b-nav card-header="card-header" tabs="tabs">
                        <b-nav-item @click="selectBtn('homedeco')">홈데코</b-nav-item>
                        <b-nav-item @click="selectBtn('furniture')">가구</b-nav-item>
                        <b-nav-item @click="selectBtn('kitchen')">주방</b-nav-item>
                    </b-nav>
                </template>
            </b-card>

            <div class="mt-4" v-for="product in products" v-bind:key="product.index" id="product">
                <h4>{{product.productName}}</h4>
                <b-card
                    img-src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
                    img-alt="Card image"
                    img-left="img-left"
                    class="mb-3">
                    <b-card-text>
                        상품 설명 :
                        {{ product.productDetail }}
                    </b-card-text>
                    <b-card-text>
                        재고 :
                        {{product.quantity}}
                    </b-card-text>
                    <b-card-text>
                        가격 :
                        {{product.price}}
                    </b-card-text>
                    <b-button v-b-modal.order-modal>
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
                </b-card>
            </div>
        </div>
    </div>

</template>

<script>
    import ProductApi from '../../api/ProductApi';
    import OrderApi from '../../api/OrderApi';
    import Order from '../../model/Order';

    export default {
        name: 'product-list',
        data: function () {
            return {
                products: [],
                order : new Order(),
            }
        },
        mounted: function () {
            ProductApi
                .findByCategories('homedeco')
                .then(data => this.products = data);
        },
        methods: {
            selectBtn : function (categories) {
                ProductApi
                    .findByCategories(categories)
                    .then(data => this.products = data)
            },
            orderRegisterHandler : function(productId, productName){
                this.makeOrder(productId, productName);
                OrderApi.register(this.order)
                .then(value => {
                   value.status === 200 ? alert('주문이 완료되었습니다.') : alert('주문을 실패하였습니다')
                });
            },
            makeOrder : function(productId, productName){
                this.order.productId = productId;
                this.order.productName = productName;
                this.order.memberId = this.$session.get('LoggedInId');
            }
        }
    }
</script>

<style>
    #product {
        padding-left: 5%;
        padding-right: 5%;
    }
</style>