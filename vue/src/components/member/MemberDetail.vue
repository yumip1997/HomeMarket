<template>
  <div></div>
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