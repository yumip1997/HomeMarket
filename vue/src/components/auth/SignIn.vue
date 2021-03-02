<template>
<div class="ui segment">
    <sui-grid-column>
      <form class="ui form">
        <div class="field">
          <label>아이디</label>
          <div class="ui left icon input">
            <input
              type="text"
              placeholder="아이디를 입력하세요."
              autocomplete="off"
              v-model="memberId"/>
            <i class="user icon"></i>
          </div>
        </div>
        <div class="field">
          <label>비밀번호</label>
          <div class="ui left icon input">
            <input
              type="password"
              placeholder="비밀번호를 입력하세요."
              autocomplete="off"
              v-model="password"
            />
            <i class="lock icon"></i>
          </div>
        </div>
        <sui-button primary @click="LoginBtnHandler" type="button">로그인</sui-button>
        <div container v-if="error">
          아이디 또는 비밀번호가 틀렸습니다!
        </div>
      </form>
    </sui-grid-column>
</div>
</template>

<script>
import {mapActions} from 'vuex'

export default {
    name : 'SingIn',
    data : () => {
        return {
            memberId : '',
            password : '',
            error : false,
        }
    },
    methods : {
      ...mapActions(['retrieveToken']),
      LoginBtnHandler : function(){
        this.retrieveToken({
          memberId : this.memberId,
          password : this.password
        })
        .then(() => {
          this.$router.push('/');
        })
        .catch(() => {
          this.error = true;
        })
      },
    }
}
</script>

<style>

</style>