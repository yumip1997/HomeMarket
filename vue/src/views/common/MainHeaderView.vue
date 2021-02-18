<template>
    <div>
    <sui-menu pointing>
      <a
        is="sui-menu-item"
        v-for="menu in leftMenus"
        :active="isActive(menu)"
        :key="menu"
        :content="menu"
        @click="menuClickHandler(menu)"
      />
      <sui-menu-menu position="right">
        <a
        is="sui-menu-item"
        v-for="menu in rightMenus"
        :active="isActive(menu)"
        :key="menu"
        :content="menu"
        @click="menuClickHandler(menu)"
      />
      </sui-menu-menu>
    </sui-menu>
  </div>
</template>

<script>
export default {
    name : 'MainHeaderView',
    props : {
      activeMenu : String,
    },
    data : function(){
        return {
            leftMenus : ['Home', '구매하기'],
            rightMenus : ['판매하기', '마이페이지', '로그아웃', '회원가입', '로그인'],
        }
    }, 
    methods : {
        menuClickHandler : function(menu) {
          this.$emit('menu-event', menu);
        },
        isActive(name) {
          return this.activeMenu === name;
        }
    },
    computed : {
      loggedIn(){
        return this.$store.getters.loggedIn;
      }
    }
}
</script>

<style>

</style>