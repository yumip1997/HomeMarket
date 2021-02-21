<template>
<sui-container>
    <sui-header dividing id="register-header"><h1>회원가입</h1></sui-header>
    <sui-form id="register-form">
    <sui-form-field>
      <label>아이디</label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.memberId"/>
    </sui-form-field>

    <sui-form-field>
      <label>비밀번호</label>
      <input type="password" placeholder="비밀번호를 입력하세요" v-model="member.password"/>
    </sui-form-field>

     <sui-form-field>
      <label>이름</label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.name"/>
    </sui-form-field>   
    
    <sui-form-field>
      <label>이메일</label>
      <input type="text" placeholder="이메일을 입력하세요" v-model="member.email"/>
    </sui-form-field>

    <sui-form-field>
      <label>주소</label>
      <sui-form-fields>
        <sui-form-field width="six">
          <label>우편번호</label>
          <input type="text" placeholder="우편번호" v-model="address.zipCode">
        </sui-form-field>
        <sui-form-field width="ten">
          <label>지번주소</label>
          <input type="text" placeholder="지번주소" v-model="address.zipAddress">
        </sui-form-field>
      </sui-form-fields>
      <sui-form-fields>
        <sui-form-field width="ten">
          <label>도로명주소</label>
          <input type="text" placeholder="도로명주소" v-model="address.streetAddress">
        </sui-form-field>
        <sui-form-field width="six">
          <label>유형</label>
        <sui-dropdown
          placeholder="유형선택"
          selection
          :options="addressType"
          v-model="address.addressType"
        />
        </sui-form-field>
      </sui-form-fields>
    </sui-form-field>
    
    <sui-button primary @click="registerBtnHandler" type="button">회원가입</sui-button>
    <submit-button />
  </sui-form>
</sui-container>
</template>

<script>
import {Member, Address} from '@/model'
import {SubmitButton} from '@/components/ui'


export default {
    name : 'MemberRegister',
    components : {
      SubmitButton
    },
    data : function() {
      return {
        member : new Member(),
        addresses : [],
        address : new Address(),
        addressType :[
          {text : '집', value : 'Home'},
          {text : '회사', value : 'Office'}
        ]
      }
    },
    methods : {
      registerBtnHandler : function(){
        //주소 설정
        this.addresses.push(this.address);
        this.member.addresses = this.addresses;
        
        this.$store.dispatch('register', this.member)
        .then(response => {
          console.log("view 단" + response)
        })
        .catch(error => {
          console.log(error);
          this.error = true;
        })
      }
    }
}
</script>

<style>

</style>