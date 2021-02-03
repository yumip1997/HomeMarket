<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-brand href="#">Home Market</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav="is-nav">
                <b-navbar-nav>
                    <b-nav-item @click="handleClickMenu('homedeco')">홈데코</b-nav-item>
                    <b-nav-item @click="handleClickMenu('funrniture')">가구</b-nav-item>
                    <b-nav-item @click="handleClickMenu('kitchen')">주방</b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                    <b-navbar-nav>
                        <b-nav-item @click="handleClickMenu('register')">가입하기</b-nav-item>
                        <b-nav-item @click="handleClickMenu('login')">로그인</b-nav-item>
                    </b-navbar-nav>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    export default {
        name: 'main-header',
        methods : {
            handleClickMenu : function(menu){
                switch(menu){
                    case 'register' :
                        this.$router.push('/member/register');
                        break;
                
            }

        }
    
    }
}
</script>

<style>
</style>