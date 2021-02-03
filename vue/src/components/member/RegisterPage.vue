<template>
<div>
  <div class="from-group">
    <label>아이디 : </label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.memberId"/>
  </div>

  <div class="from-group">
    <label>이름 : </label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.name"/>
  </div>

  <div class="from-group">
    <label>비밀번호 : </label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.password"/>
  </div>

    <div class="from-group">
    <label>이메일 : </label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.email"/>
  </div>

  <div class="from-group">
    <label>주소 : </label>
      <input type="text" placeholder="아이디를 입력하세요" v-model="member.address"/>
  </div>
  <button primary @click="onClickRegisterBtn" type="button">회원가입</button>
</div>
</template>

<script>
import {registerMember} from '../../api/MemberApi.js';

export default {
    name : 'RegisterPage',
    data : function(){
        return {
            member : {}
        }
    },
    methods : {
        onClickRegisterBtn : async function(){
            await registerMember(this.member);
        }
    }
}
</script>

<style>

</style>