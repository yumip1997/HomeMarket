<template>
  <b-container>
    <b-container id="register" class="text-center">
      <h1>상품 등록</h1>
    </b-container>

    <b-container>
      <b-container>
        <b-form-group 
            label="상품이름 : ">
         <b-form-input 
            type="text"
            placeholder="상품이름을 입력하세요"
            v-model="product.productName">
        </b-form-input>
        </b-form-group>

        <b-form-group  
            label="상품설명 : ">
         <b-form-input 
            type="text"
            placeholder="이름을 입력하세요"
            v-model="product.productDetail">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="카테고리 : ">
            <b-checkbox value="homedeco" v-model="product.categories" checked >홈데코</b-checkbox>
            <b-checkbox value="furniture" v-model="product.categories" >가구</b-checkbox>
            <b-checkbox value="kitchen" v-model="product.categories" >주방</b-checkbox>
        </b-form-group>

        <b-form-group 
            label="수량 : ">
        <b-form-input 
            type="text"
            placeholder="수량을 입력하세요"
            v-model="product.quantity">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="가격 : ">
        <b-form-input 
            type="text"
            placeholder="가격을 입력하세요"
            v-model="product.price">
        </b-form-input>
        </b-form-group>
        <b-button type="button" @click="register">상품등록하기</b-button>       
        </b-container>
    </b-container>
  </b-container>
</template>

<script>
import { ProductApi } from '@/api'
import { Product } from '@/model'

export default {
    name : 'product-register',
    data : function(){
      return {
        product : new Product()
      };
    },
    methods : {
      register : function(){
        this.product.memberId = this.$session.get("LoggedInId");
        ProductApi.register(this.product)
        .then(value => {
          console.log(value.status)
          if(value.status === 200){
            alert('상품 등록이 완료되었습니다.')
            this.$router.push('/product/list')
          }else{
            alert('상품 등록을 실패하였습니다.')
          }
      })
    }
  }
}
</script>

<style>

</style>