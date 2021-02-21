<template>
<member-register />
</template>

<script>
import {MemberRegister} from '@/components'

export default {
  name : 'MemberRegisterView',
  components:  {
    MemberRegister
  }

}
</script>

<style>

#register-header {
  margin : 30px;
}
#register-form {
  padding-left : 30px;
  padding-right : 30px;
}
</style>