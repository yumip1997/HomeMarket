<template>
    <div>
      <sui-menu pointing>
        <a 
        is="sui-menu-item"
        :active="isActive('home')"
        @click="menuClickHandler('home')"
        >Home
        </a>
        <a 
        is="sui-menu-item"
        :active="isActive('buying')"
        @click="menuClickHandler('buying')"
        >구매하기
        </a>
        <a 
        is="sui-menu-item"
        :active="isActive('selling')"
        @click="menuClickHandler('selling')"
        >판매하기
        </a>

        <sui-menu-menu position="right">
        <a
        v-if="isLoggedIn" 
        is="sui-menu-item"
        :active="isActive('myInfo')"
        @click="menuClickHandler('myInfo')"
        >마이페이지
        </a>
        <a 
        v-if="isLoggedIn"
        is="sui-menu-item"
        :active="isActive('selling')"
        @click="menuClickHandler('logout')"
        >로그아웃
        </a>
        <a
        v-if="!isLoggedIn" 
        is="sui-menu-item"
        :active="isActive('signUp')"
        @click="menuClickHandler('signUp')"
        >회원가입
        </a>
        <a
        v-if="!isLoggedIn" 
        is="sui-menu-item"
        :active="isActive('signIn')"
        @click="menuClickHandler('signIn')"
        >로그인
        </a>
        </sui-menu-menu>
    </sui-menu>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
    name : 'MainMenu',
    data : function() {
        return {
            activeMenu : 'home',
        }
    },
    methods : {
      menuClickHandler : function(menu) {
        this.activeMenu = menu;
          
        switch (menu) {
          case 'home' :
            this.$router.push('/');
            break;
          case 'myInfo' :
            this.$router.push('/member/detail');
            break;
          case 'signUp' :
            this.$router.push('/member/register');
            break;
          case 'signIn' :
            this.$router.push('/auth/signIn');
            break;
          case 'logout' :
            this.$store.dispatch('destoryToken');
            this.$router.push('/');
        }
      },
      isActive : function(menu) {
        return this.activeMenu === menu;
      },
    },
    computed : {
      ...mapGetters(['isLoggedIn'])
    }
}
</script>

<style>

</style>