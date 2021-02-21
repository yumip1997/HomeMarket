<template>
  <div></div>
</template>

<script>
export default {
    name : 'MemberDetail',
    created : function(){
      this.$store.dispatch('findByMemberId', this.$store.state.loggedInMember);
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