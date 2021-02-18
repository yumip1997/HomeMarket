<template>
<login-view :message="errorMessage" @login-event="loginHandler"/>
</template>

<script>
import {LoginView} from '@/views'
import {LoginApi} from '@/api'

export default {
    name : 'Login',
    components : {
        LoginView,
    },
    data : function(){
        return {
            errorMessage : null
        }
    },
    methods : {
        loginHandler : function(memberId, password){
            LoginApi.login(memberId, password)
            .then(value => {
                console.log(value);
                console.log(value.memberId);
            })
        }
    }
}
</script>

<style>

</style>