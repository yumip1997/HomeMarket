<template>
 <div>
        <div id="myInfo">
            <div id="sui-divider" horizontal="horizontal">
                <h4 is="sui-header">
                    <i class="user icon"></i>
                    나의정보
                </h4>
            </div>

            <table class="ui definition table">
                <tbody v-if="page==='register'">
                    <tr>
                        <td class="two wide column">아이디</td>
                        <td>{{member.memberId}}</td>
                    </tr>
                    <tr>
                        <td class="two wide column">이름</td>
                        <td>{{member.name}}</td>
                    </tr>
                    <tr>
                        <td class="two wide column">이메일</td>
                        <td>{{member.email}}</td>
                    </tr>
                    <tr>
                        <td class="two wide column">주소</td>
                        <td>{{member.address}}</td>
                    </tr>
                    
                    <tr>
                        <td class="two wide column">가입일</td>
                        <td>{{member.joinDate}}</td>
                    </tr>
                    <tr>
                        <td class="two wide column">권한</td>
                        <td>{{member.auth}}</td>
                    </tr>                                              
                </tbody>

                <tbody v-if="page==='update'">
                    <tr>
                        <td class="two wide column">이름</td>
                        <td><sui-input type="text" v-model="member.name" /></td>
                    </tr>
                    <tr>
                        <td class="two wide column">비밀번호</td>
                        <td><sui-input type="password" v-model="member.password" /></td>
                    </tr>
                    <tr>
                        <td class="two wide column">이메일</td>
                        <td><sui-input type="text" v-model="member.email" /></td>
                    </tr>
                    <tr>
                        <td class="two wide column">주소</td>
                        <td><sui-input type="text" v-model="member.address" /></td>
                    </tr>                 
                </tbody>
            </table>
        </div>
        <div v-if="page=='register'">
            <sui-button primary="primary" @click="onClickModifyBtn" type="button">수정하기</sui-button>
            <sui-button primary="primary" @click="onClickRemoveBtn" type="button">탈퇴하기</sui-button>
        </div>
        <div v-else>
            <sui-button primary="primary" @click="onClickSumbitBtn" type="button">수정완료</sui-button>
        </div>
 </div>
</template>

<script>
import {findMemberById} from '../../api/MemberApi.js'
import {modifyMember} from '../../api/MemberApi.js'
import {removeMember} from '../../api/MemberApi.js'

export default {
    name : 'MyInfoPage',
    mounted : async function(){
        let Member = await findMemberById('yumi3');
        Member.joinDate = this.$moment(Member.joinDate).format('YYYY년 MM월 DD일');
        this.member = Member;
        
    },
    data : function(){
        return {
            member : {},
            page : 'register'
        }
    },
    methods : {
        onClickModifyBtn : function(){
            this.page = 'update';
        },
        onClickSumbitBtn : async function(){
            let flag = await modifyMember(this.member);
            if(flag){
                this.$router.go('/member/myInfo');
            }
        },
        onClickRemoveBtn : async function(){
            let flag = await removeMember(this.member.memberId);
            if(flag){
                this.$router.go('/');
            }
            
        }
    }
}
</script>

<style>

</style>