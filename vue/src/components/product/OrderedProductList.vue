<template>
  <div>
    <b-container id="orderArea" class="text-center">
        <h2>판매 상품 주문 목록</h2>
    </b-container>

    <b-container>
        <table class="table table-hover text-center">
            <th>상품 번호</th>
            <th>주문 번호</th>
            <th>상품 이름</th>
            <th>주문자</th>
            <th>재고</th>
            <th>주문 수량</th>
            <th>주문 상태</th>
            <tr v-for="orderedProduct in orderedProducts" v-bind:key="orderedProduct.index">
                <td>{{orderedProduct.productId}}</td>
                <td>{{orderedProduct.orderId}}</td>
                <td>{{orderedProduct.productName}}</td>
                <td>{{orderedProduct.buyer}}</td>
                <td>{{orderedProduct.stock}}</td>
                <td>{{orderedProduct.count}}</td>
                <td>{{orderedProduct.state}}</td>
               
            </tr>
        </table>
    </b-container>
  </div>
</template>

<script>
import {ProductApi} from '@/api'
//import {MyProduct} from '@/model'

export default {
    name : 'ordered-product-list',
    data : function(){
        return {
            orderedProducts : {},
        }
    },
    mounted : function(){
        const memberId = this.$session.get("LoggedInId");
        ProductApi.findOrderedProduct(memberId)
        .then(data => this.orderedProducts = data)
    }
    
}
</script>

<style>

</style>