<template>
<div>
    <b-container id="orderArea">
        <h2>주문 목록</h2>
    </b-container>

    <b-container>
        <table class="table table-hover">
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
                    <b-button class="ml-3" v-b-modal.order-modal>주문 수정하기</b-button>
                    <b-modal id="order-modal" title=주문수정하기 @ok="orderModifyHandler(order.orderId)">
                        <b-form-group>
                            <b-form-input v-model="order.count" placeholder="주문수량"></b-form-input>
                        </b-form-group>
                        <b-form-group>
                            <b-form-input v-model="order.address" placeholder="배송지"></b-form-input>
                        </b-form-group>
                    </b-modal>

                    <b-button class="ml-3" @click="orderDeleteHandler(order.productId, order.orderId)">주문 취소하기</b-button>
                </td>
            </tr>
        </table>
    </b-container>
</div>
  
</template>

<script>
import OrderApi from '../../api/OrderApi';
import Order from '../../model/Order';

export default {
    name : 'order-list',
    data : function(){
        return {
            orders : [],
            order : new Order()
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
        orderModifyHandler : function(){
            //주문 수정
        },
        orderDeleteHandler : function(productId, orderId){
           OrderApi.delete(productId, orderId)
           .then(value => {
               value.status === 200 ? alert('주문 취소가 완료되었습니다.') : alert('주문 취소를 실패하였습니다.');
               this.$router.push('/order/list');
           })
        }
    }
}
</script>

<style>
#orderArea {
    margin : 30px
}
</style>