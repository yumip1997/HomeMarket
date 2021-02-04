<template>
    <div>
        <div id="productList">
            <b-card title="상품 리스트" body-class="text-center" header-tag="nav">
                <template #header>
                    <b-nav card-header="card-header" tabs="tabs">
                        <b-nav-item @click="select('homedeco')">홈데코</b-nav-item>
                        <b-nav-item @click="select('furniture')">가구</b-nav-item>
                        <b-nav-item @click="select('kitchen')">주방</b-nav-item>
                    </b-nav>
                </template>
            </b-card>

            <div class="mt-4" v-for="product in products" v-bind:key="product.index" id="product">
                <h4>{{product.productName}}</h4>
                    <b-card img-src="https://placekitten.com/300/300" img-alt="Card image" img-left class="mb-3">
                         <b-card-text>
                             상품 설명 : {{ product.productDetail }}
                         </b-card-text>
                         <b-card-text>
                             수량 : {{product.quantity}}
                         </b-card-text>
                        <b-card-text>
                             가격 : {{product.price}}
                         </b-card-text>
                         
                         <b-button href="#" variant="primary">주문하기</b-button>
                    </b-card>
            </div>
        </div>
  </div>

</template>

    <script>
        import ProductApi from '../../api/ProductApi';

        export default {
            name: 'product-list',
            data: function () {
                return {products: []}
            },
            methods: {
                select: function (categories) {
                    ProductApi
                        .findByCategories(categories)
                        .then(data => this.products = data)
                }
            }
        }
    </script>

    <style>
    #product{
        padding-left : 5%;
        padding-right : 5%;
    }
    </style>