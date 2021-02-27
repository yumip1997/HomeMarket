<template>
  <sui-container>
    <div is="sui-divider" horizontal>
      <h4 is="sui-header">
        <i class="bar chart icon"></i>
        나의 정보
      </h4>
    </div>
    <div>
    <h5 is="sui-header" emphasis="secondary" attached="top">
      아이디
    </h5>
    <sui-segment attached>
      <h5>{{member.memberId}}</h5>
    </sui-segment>
    <h5 is="sui-header" attached>
      이름
    </h5>
    <sui-segment attached>
      <h5>{{member.name}}</h5>
    </sui-segment>
    <h5 is="sui-header" attached>
      이메일
    </h5>
    <sui-segment attached>
      <h5>{{member.email}}</h5>
    </sui-segment>
    <h5 is="sui-header" attached>
      주소
    </h5>
    <sui-segment attached>
      <sui-segments v-for="(address, index) in member.addresses" :key="index"> 
        <sui-segment>
          <sui-grid>
            <sui-grid-row>
              <sui-grid-column :width="4">우편번호</sui-grid-column>
              <sui-grid-column :width="4">{{address.zipCode}}</sui-grid-column>
              <sui-grid-column :width="4">지번주소</sui-grid-column>
              <sui-grid-column :width="4">{{address.zipAddress}}</sui-grid-column>
            </sui-grid-row>
          </sui-grid>
        </sui-segment>

        <sui-segment>
          <sui-grid>
            <sui-grid-row>
              <sui-grid-column :width="4">도로명 주소</sui-grid-column>
              <sui-grid-column :width="6">{{address.streetAddress}}</sui-grid-column>
              <sui-grid-column :width="1">유형</sui-grid-column>
              <sui-grid-column :width="1">{{address.addressType}}</sui-grid-column>
            </sui-grid-row>
          </sui-grid>
        </sui-segment>
      </sui-segments>
    </sui-segment>
  </div>
  <sui-button primary @click="modifyBtnHandler" type="button">수정하기</sui-button>
  </sui-container>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
    name : 'MemberDetail',
    created : function(){
      const memberId = this.loggedInMember;
      this.findByMemberId(memberId);
      
    },
    methods : {
      ...mapActions({
        findByMemberId : 'findByMemberId'
      }),
      modifyBtnHandler : function(){
        this.$router.push('/member/modify')
      }
    },
    computed : {
      ...mapGetters({
        loggedInMember : 'getLoggedInMember',
        member : 'getMember'
      })
    }
}
</script>

<style>
</style>