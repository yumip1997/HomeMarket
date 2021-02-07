<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-brand @click="handleClickMenu('home')">Home Market</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav="is-nav">
                <b-navbar-nav>
                    <b-nav-item @click="handleClickMenu('shopping')">쇼핑하기</b-nav-item>
                    <b-nav-item @click="handleClickMenu('order')" v-if="IsLoggedIn">나의 주문 목록</b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-navbar-nav>
                        <b-nav-item @click="handleClickMenu('selling')" v-if="IsLoggedIn">판매하기</b-nav-item>
                        <b-nav-item @click="handleClickMenu('myInfo')" v-if="IsLoggedIn">마이페이지</b-nav-item>
                        <b-nav-item @click="handleClickMenu('logout')" v-if="IsLoggedIn">로그아웃</b-nav-item>
                        <b-nav-item @click="handleClickMenu('register')" v-if="!IsLoggedIn">가입하기</b-nav-item>
                        <b-nav-item @click="handleClickMenu('login')" v-if="!IsLoggedIn">로그인</b-nav-item>
                    </b-navbar-nav>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    export default {
        name: 'main-header',
        data : function(){
            return {
                IsLoggedIn : false
            }
        },
        mounted : function(){
            const LoggedInMemberId = this.$session.get('LoggedInId');
            if(LoggedInMemberId){
                this.IsLoggedIn = true;
            }else{
                this.IsLoggedIn = false;
            }
        },
        methods: {
            handleClickMenu: function (menu) {
                switch (menu) {
                    case 'home':
                        this.$router.push('/');
                        break;
                    case 'shopping':
                        this.$router.push('/product/list');
                        break;
                    case 'order' :
                        this.$router.push('/order/list');
                        break;
                    case 'register':
                        this.$router.push('/member/register');
                        break;
                    case 'selling' :
                        this.$router.push('/product/register');
                        break;
                    case 'myInfo' :
                        this.$router.push('/member/myInfo');
                        break;
                    case 'login' :
                        this.$router.push('/login').catch(() => {});
                        break;
                    case 'logout' :
                        this.$session.remove('LoggedInId');
                        this.$router.push('/');
                        this.$router.go('/');
                        break;
                }
            }
        }
    }
</script>

<style></style>