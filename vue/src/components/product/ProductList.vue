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
                        <b-button type="button" @click="detailBtn(product.productId)">상세보기</b-button>
                    </b-card-text>
                </b-card>
            </div>
        </div>
    </div>

</template>

<script>
    import { ProductApi }from '@/api'

    export default {
        name: 'product-list',
        data: function () {
            return {
                products: [],
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
            detailBtn : function(productId){
                this.$router.push({
                    path : '/product/detail/'+productId
                })
            },
        }
    }
</script>

<style>
    #product {
        padding-left: 5%;
        padding-right: 5%;
    }
</style>