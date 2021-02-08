<template>
<div>
    <b-container id="orderArea" class="text-center">
        <h2>주문 목록</h2>
    </b-container>

    <b-container>
        <table class="table table-hover text-center">
            <th>주문 상품</th>
            <th>주문 수량</th>
            <th>주문 상태</th>
            <th>주문 날짜</th>
            <th></th>
            <tr v-for="order in orders" v-bind:key="order.index">
                <td>{{order.productName}}</td>
                <td>{{order.count}}</td>
                <td>{{order.state}}</td>
                <td>{{order.orderDate}}</td>
                <td>
                    <b-button class="ml-3" v-b-modal="'order-modal'" @click="orderDetailHandler(order.orderId)">상세보기</b-button>
                </td>
            </tr>
        </table>
    </b-container>
</div>
  
</template>

<script>
import { OrderApi } from '@/api';
import { Order } from '@/model';

export default {
    name : 'order-list',
    data : function(){
        return {
            orders : [],
            index : '',
            changedOrder : new Order(),
        }
    },
    mounted : function(){
        const memberId = this.$session.get("LoggedInId");
        OrderApi.findAll(memberId)
        .then(data => {
            this.orders = data;
            this.orders.forEach(element => element.orderDate = this.$moment().format('YYYY년 MM월 DD일'));
        })
    },
    methods : {
       orderDetailHandler : function(orderId){
           this.$router.push('/order/detail/'+orderId)
       }
    }
}
</script>

<style>
#orderArea {
    margin-top : 30px;
    margin-bottom : 30px
}
</style>