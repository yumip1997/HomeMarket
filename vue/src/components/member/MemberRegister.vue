<template>
  <member-register-view :reigsterOk="this.registerCheck" @register-event="registerHandler">
  </member-register-view>
</template>

<script>
import {MemberRegisterView} from '@/views'
import {MemberApi} from '@/api'

export default {
    name : 'MemberRegister',
    components : {
        MemberRegisterView,
    },
    data : function(){
      return {
        registerCheck : false,
      }
    },
    methods : {
      registerHandler : function(member){
        console.log(member)
        MemberApi.register(member)
        .then(value => { 
          console.log(value)
          value === 200 ? this.registerCheck = true : this.registerCheck = false
          this.isOkRegister(this.registerCheck)
        })
      },
      isOkRegister : function(registerCheck){
        if(registerCheck){
          alert('회원가입이 완료되었습니다.')
          this.$router.push('/')
        }else{
          alert('다시 시도해주세요!')
        }
      }
    }
}
</script>

<style>

</style>