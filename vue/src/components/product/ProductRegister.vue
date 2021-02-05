<template>
  <b-container>
    <b-container id="register" class="text-center">
      <h1>상품 등록</h1>
    </b-container>

    <b-container>
      <b-container>
        <b-form-group 
            label="아이디 : ">
         <b-form-input 
            type="text"
            placeholder="아이디를 입력하세요"
            v-model="member.memberId">
        </b-form-input>
        </b-form-group>

        <b-form-group  
            label="이름 : ">
         <b-form-input 
            type="text"
            placeholder="이름을 입력하세요"
            v-model="member.name">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="이메일 : ">
        <b-form-input 
            type="text"
            placeholder="이메일을 입력하세요"
            v-model="member.email">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="비밀번호 : ">
        <b-form-input 
            type="password"
            placeholder="비밀번호를 입력하세요"
            v-model="member.password">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="주소 : ">
        <b-form-input 
            type="text"
            placeholder="주소를 입력하세요"
            v-model="member.address">
        </b-form-input>
        </b-form-group>
        <b-button type="button" @click="register">상품등록하기</b-button>       
        </b-container>
    </b-container>
  </b-container>
</template>

<script>
import Product from '../../model/Product'
import ProductApi from '../../api/ProductApi'

export default {
    name : 'product-register',
    data : function(){
      return {
        product : new Product()
      };
    },
    methods : function(){
      ProductApi.register(this.product)
      .then(value => value === 201 ? alert('상품 등록이 완료되었습니다.') : alert('상품 등록을 실패하였습니다.'));
      this.$router('/sell/register')
    }

}
</script>

<style>

</style>