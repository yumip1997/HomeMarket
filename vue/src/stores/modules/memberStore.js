import {MemberApi} from '@/api'
import {Member} from '@/model'

const memberStore = {
    state : {
        member : new Member(), 
    },
    getters : {
       member(state){
           return state.member;
       }
    },
    mutations : {
       findByMemberId : (state, payload) => {
           return state.member.push(payload);
       },
       
    },
    actions : {
        register(context, member){
            return new Promise((resolve, reject) => {
                MemberApi.register(member)
                .then(response => {
                    console.log(response);
                    resolve(response);
                })
                .catch(error => {
                    console.log(error);
                    reject(error);
                })
            })
        },
        
        findByMemberId(context, payload){
            return new Promise((resolve, reject) => {
                MemberApi.findByMemberId(payload)
                .then(response => {
                    console.log(response);
                    //mutations에 commit해줘야함
                    context.commit('findByMemberId');
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                    console.log(error);
                })
            })
        }
    }
}

export default memberStore
