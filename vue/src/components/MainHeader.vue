<template>
<b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">Home Market</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item @click="handleClickMenu('home')">Home</b-nav-item>
        <b-nav-item @click="handleClickMenu('homedeco')">홈데코</b-nav-item>
        <b-nav-item @click="handleClickMenu('furniture')">가구</b-nav-item>
        <b-nav-item @click="handleClickMenu('kitchen')">주방</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item @click="handleClickMenu('register')">가입하기</b-nav-item>
        <b-nav-item @click="handleClickMenu('sell')">판매하기</b-nav-item>
        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <em>User</em>
          </template>
          <b-dropdown-item @click="handleClickMenu('myInfo')">마이페이지</b-dropdown-item>
          <b-dropdown-item @click="handleClickMenu('logout')">로그아웃</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
    export default {
        name: "MainHeader",
        methods: {
            handleClickMenu: function (menuName) {
                switch (menuName) {
                    case 'home':
                        this.$router.go('/');
                        break;
                    case 'homedeco':
                        this.$router.go('/');
                        break;
                    case 'register':
                        this.$router.push('/member/register');
                        break;
                    case 'myInfo':
                        this.$router.go('/member/myInfo');
                        break;
                }
            }
        }
    }
</script>

<style>
#header-form{
    padding : 10px;
    font-size : 3rem;
}
</style>