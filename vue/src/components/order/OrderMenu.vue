<template>
  <sui-menu tabular>
      <a
        is="sui-menu-item"
        v-for="(value,name,index) in itemsAsKorean"
        :key="index"
        :active="isActive(name)"
        :content="value"
        @click="orderMenuBtnHandler(name)"
        >
      </a>
  </sui-menu>
</template>

<script>
export default {
    name : 'OrderMenu',
    data : function(){
        return {
            itemsAsKorean : {
                orderList : '주문목록',
                sellingProductOrderList : '판매상품 주문목록'
            },
        }
    }
}
</script>

<style>

</style>