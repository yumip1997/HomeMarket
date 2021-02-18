<template>
<main-header-view 
:activeMenu="this.currentMenu" 
@menu-event="menuRouteHandler"/>
</template>

<script>
import { MainHeaderView } from '@/views'

export default {

    name : 'MainHeader',
    components : {
        MainHeaderView,
    },
    data : function() {
        return {
            currentMenu : 'Home',
        }
    },
    methods : {
        menuRouteHandler : function(menu){
            this.currentMenu = menu;

            switch(this.currentMenu){
                case 'Home' :
                    this.$router.push('/')
                    break
                case '회원가입' :
                    this.$router.push('/member/register')
                    break
                case '로그인' :
                    this.$router.push('/login')
                    break
            }
        }
    },
}
</script>

<style>

</style>