<template>
    <sui-container>
    <sui-header dividing><h1>마이페이지</h1></sui-header>
    <sui-form id="register-form">
    <sui-form-field>
      <label>아이디</label>
      <input type="text" v-model="member.memberId"/>
    </sui-form-field>

     <sui-form-field>
      <label>이름</label>
      <input type="text" v-model="member.name"/>
    </sui-form-field>   
    
    <sui-form-field>
      <label>이메일</label>
      <input type="text" v-model="member.email"/>
    </sui-form-field>

  <sui-form-field>
    <label>주소</label>
    <sui-form-field v-for="(address, index) in member.addresses" v-bind:key='index'> 
      <sui-form-fields>
        <sui-form-field width="six">
          <label>우편번호</label>
          <input type="text" v-model="member.addresses[index].zipCode">
        </sui-form-field>
        <sui-form-field width="ten">
          <label>지번주소</label>
          <input type="text" v-model="member.addresses[index].zipAddress">
        </sui-form-field>
      </sui-form-fields>
      <sui-form-fields>
        <sui-form-field width="ten">
          <label>도로명주소</label>
          <input type="text" v-model="member.addresses[index].streetAddress">
        </sui-form-field>
        <sui-form-field width="six">
          <label>유형</label>
        <sui-dropdown
          placeholder="유형선택"
          selection
          :options="addressType"
          v-model="member.addresses[index].addressType"
        />
        </sui-form-field>
      </sui-form-fields>
    </sui-form-field>
  </sui-form-field>
  <sui-button primary @click="modifyCompletedBtnHandler" type="button">수정완료</sui-button>
  </sui-form>
</sui-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
    name : 'MemberModify',
    data : function(){
      return {
        addressType : [
          {text : '집', value : 'Home'},
          {text : '회사', value : 'Office'}
        ]
      }
    },
    methods : {
      modifyCompletedBtnHandler : function(){
        alert('수정 완료!');
      }
    },
    computed : {
      ...mapGetters({
        member : 'getMember'
      })
    }
}
</script>

<style>

</style>