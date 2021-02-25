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
        state.member = payload;
       },
       
    },
    actions : {
        register(context, member){
            MemberApi.register(member)
            .then(response => {
                console.log(response)
                return response;
            })
            .catch(error => {
                console.log(error)
            })
        },
        
        findByMemberId(context, payload){
            return new Promise((resolve, reject) => {
                MemberApi.findByMemberId(payload)
                .then(response => {
                    context.commit('findByMemberId', response);
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
