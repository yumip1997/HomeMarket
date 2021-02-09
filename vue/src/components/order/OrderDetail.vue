<template>
  <div>
 <b-container class="text-center" id="my-info">
        <h2>주문 상세</h2>
    </b-container>

    <b-container id="my-content">
        <b-row>
            <b-col cols="4">주문 번호</b-col>
            <b-col cols="8">{{order.orderId}}</b-col>
        </b-row>

         <b-row>
            <b-col cols="4">주문 상품</b-col>
            <b-col cols="8">{{order.productName}}</b-col>
        </b-row>

        <b-row>
            <b-col cols="4">주문 수량</b-col>
            <b-col cols="8">{{order.count}}</b-col>
        </b-row> 

        <b-row>
            <b-col cols="4">주문 상태</b-col>
            <b-col cols="8">{{order.state}}</b-col>
        </b-row>

        <b-row>
            <b-col cols="4">주문 날짜</b-col>
            <b-col cols="8">{{order.orderDate}}</b-col>
        </b-row>

        <b-row>
            <b-button class="ml-3" v-b-modal="'order-modal'">주문 수정하기</b-button>
            <b-button class="ml-3" @click="orderCancelHanlder(order.productId, order.orderId)">주문 취소하기</b-button>
            <b-modal id="order-modal" title="주문 수정하기" @ok="orderModifyHandler(order.orderId)">
                <b-form-group>
                    <b-form-input v-model="changedOrder.count" placeholder="주문수량"></b-form-input>
                </b-form-group>
                <b-form-group>
                    <b-form-input v-model="changedOrder.address" placeholder="배송지"></b-form-input>
                </b-form-group>
            </b-modal>

        </b-row>
    </b-container>
   
  </div>
</template>

<script>
import { OrderApi } from '@/api'
import { Order } from '@/model'

export default {
    name : 'order-detail',
    data : function(){
        return {
            order : new Order(),
            changedOrder : new Order(),
            status : null,
        }
    },
    mounted : function(){
        const orderId = this.$route.params.id
        OrderApi.find(orderId)
        .then(data => {
            this.order = data
            this.order.orderDate = this.$moment().format('YYYY년 MM월 DD일')
        })
    },
    methods : {
        orderModifyHandler : function(orderId){
            this.changedOrder.productId = this.order.productId
            this.changedOrder.orderId = orderId
           
            OrderApi.modify(this.changedOrder)
            .then(value =>
            {
                if(value.status === 200){
                    alert('주문변경 완료되었습니다.')
                    this.$router.push('/order/list')
                }else{
                    alert('주문 변경이 실패되었습니다.')
                }
            })
        },
        orderCancelHanlder : function(productId, orderId){
            OrderApi.delete(productId, orderId)
            .then(value => 
            {
                if(value.status === 200){
                    alert('주문 변경 완료되었습니다.')
                    this.$router.push('/order/list')
                }else{
                    alert('주문 변경이 실패되었습니다.')
                }
            })
        }
    }
}
</script>

<style>

</style>