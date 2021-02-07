<template>
    <b-container>
        <b-container id="register" class="text-center">
            <h1>로그인</h1>
        </b-container>

        <b-container>
            <b-form-group 
                label="아이디 : ">
            <b-form-input 
                type="text"
                placeholder="아이디를 입력하세요"
                v-model="memberId">
            </b-form-input>
            </b-form-group>

            <b-form-group 
                label="비밀번호 : ">
            <b-form-input 
                type="password"
                placeholder="비밀번호를 입력하세요"
                v-model="password">
            </b-form-input>
            </b-form-group>
            <b-button type="button" @click="login">로그인</b-button>
            <span>{{message}}</span> 
        </b-container>
    </b-container>
</template>

<script>
import { LoginApi } from '@/api';

export default {
    name : 'login-vue',
    data : function(){
        return {
            memberId : '',
            password : '',
            check : false,
            message : '',
        }
    },
    methods : {
        login : function(){
             LoginApi.login(this.memberId, this.password)
             .then(data => {
                 this.check = data;
                 this.loginCheck();
             });
        },
        loginCheck : function(){
            if(this.check){
                this.$session.set("LoggedInId", this.memberId);
                this.$router.push('/');
                this.$router.go('/');
            }else{
                this.message = '아이디 또는 비밀번호가 일치하지 않습니다!';
            }
        }
    }

}

</script>

<style>

</style>