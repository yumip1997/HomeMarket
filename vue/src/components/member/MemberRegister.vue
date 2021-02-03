<template>
<b-container>
    <b-container id="register" class="text-center">
        <h1>회원가입</h1>
    </b-container>

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
            label="주소 : ">
        <b-form-input 
            type="text"
            placeholder="주소를 입력하세요"
            v-model="member.address">
        </b-form-input>
        </b-form-group>
        <b-button type="button" @click="register">가입하기</b-button>       
        </b-container>
</b-container>
</template>

<script>
import Member from '../../model/Member';
import MemberApi from '../../api/MemberApi';

export default {
    name : 'member-register',
    data : function(){
        return {
            member : new Member()
        };
    },
    methods :{
        register : function(){
            MemberApi.register(this.member)
            .then(value => console.log(value));
        }
    }
}
</script>

<style>
#register {
    padding : 20px
    
}
</style>