<template>
  <div>
    <b-container class="text-center" id="my-info">
        <h2>마이페이지</h2>
    </b-container>

    <b-container id="my-content">
        <b-row>
            <b-col cols="4">아이디</b-col>
            <b-col cols="8">{{member.memberId}}</b-col>
        </b-row>

         <b-row>
            <b-col cols="4">이름</b-col>
            <b-col cols="8">{{member.name}}</b-col>
        </b-row>

        <b-row>
            <b-col cols="4">이메일</b-col>
            <b-col cols="8">{{member.email}}</b-col>
        </b-row> 

        <b-row>
            <b-col cols="4">주소</b-col>
            <b-col cols="8">{{member.address}}</b-col>
        </b-row>

        <b-row>
            <b-col cols="4">가입일</b-col>
            <b-col cols="8">{{member.joinDate}}</b-col>
        </b-row>
    </b-container>
    
    <b-container>
        <b-row align-h="end">
            <b-col cols="2"><b-button type="button" @click="modify">수정하기</b-button></b-col>
            <b-col cols="2"> <b-button type="button" @click="remove">삭제하기</b-button></b-col>
        </b-row>
    </b-container>
  </div>
</template>

<script>
import Member from '../../model/Member';
import MemberApi from '../../api/MemberApi';

export default {
    name : 'my-info',
    data : function(){
        return {
            member : new Member()
        }
    },
    mounted : function() {
        const currentMemberId = this.$session.get('LoggedInId');
        MemberApi.findById(currentMemberId)
        .then(data => {
            this.member = data;
            this.member.joinDate = this.$moment(this.joinDate).format('YYYY년 MM월 DD일');
        });
    }, methods :{
        modify : function(){
            this.$router.push('/member/modify');
        },
        remove : function(){
            MemberApi.delete(this.member.memberId)
            .then(value => console.log(value));
            this.$session.remove('LoggedInId');
            this.$router.push('/');
        }
    }
}
</script>

<style>
#my-info {
    padding : 10px
}

#my-content {
    padding : 30px
}
</style>