<template>
  <div>
    <div is="sui-divider" horizontal>
      <h4 is="sui-header">
        <i class="bar chart icon"></i>
        Specifications
      </h4>
    </div>

    <table class="ui definition table">
      <tbody>
        <tr>
          <td class="two wide column">아이디</td>
          <td>{{member.memberId}}</td>
        </tr>
        <tr>
          <td>이름</td>
          <td>{{member.name}}</td>
        </tr>
        <tr>
          <td>이메일</td>
          <td>{{member.email}}</td>
        </tr>
        <tr>
          <td>주소</td>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
    name : 'MemberDetail',
    created : function(){
      const memberId = this.$store.getters.loggedInMember;
      this.$store.dispatch('findByMemberId', memberId);
    },
    computed : {
      member : function(){
        return this.$store.getters.member;
      }
    }
}
</script>

<style>

</style>