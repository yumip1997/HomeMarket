<template>
<b-container>
    <b-container id="register" class="text-center">
        <h1>수정하기</h1>
    </b-container>

    <b-container>
        <b-form-group  
            label="이름 : ">
         <b-form-input 
            type="text"
            placeholder="이름을 입력하세요"
            v-model="member.name">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="이메일 : ">
        <b-form-input 
            type="text"
            placeholder="이메일을 입력하세요"
            v-model="member.email">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="비밀번호 : ">
        <b-form-input 
            type="password"
            placeholder="비밀번호를 입력하세요"
            v-model="member.password">
        </b-form-input>
        </b-form-group>

        <b-form-group 
            label="주소 : ">
        <b-form-input 
            type="text"
            placeholder="주소를 입력하세요"
            v-model="member.address">
        </b-form-input>
        </b-form-group>
        <b-button type="button" @click="modify">수정하기</b-button>  
        </b-container>
</b-container>
</template>

<script>
import Member from '../../model/Member';
import MemberApi from '../../api/MemberApi';

export default {
    name : 'member-modify',
    data : function(){
        return {
            member : new Member()
        }
    },
    mounted : function(){
      const currentMemberId = this.$session.get('LoggedInId');
      MemberApi.findById(currentMemberId)
      .then(data => {
          this.member = data;
          this.member.joinDate = this.$moment(this.joinDate).format('YYYY년 MM월 DD일');
      });  
    }, methods : {
        modify : function(){
            MemberApi.modify(this.member)
            .then(value => console.log(value));

            this.$router.push('/member/myInfo');
        }
    }

}
</script>

<style>

</style>