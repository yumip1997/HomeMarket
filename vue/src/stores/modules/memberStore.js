import {MemberApi} from '@/api'
import {Member} from '@/model'

const memberStore = {
    state : {
        member : new Member(), 
    },
    getters : {
       getMember(state){
           return state.member;
       }
    },
    mutations : {
       findByMemberId : (state, payload) => {  
        state.member = payload;
       },
       
       remove : (state) => {
           state.member = null;
       }
    },
    
    actions : {
        register(context, payload){
            return new Promise((resolve, reject) => {
                MemberApi.register(payload)
                .then(response => {
                    resolve(response);
                })
                .catch(error =>{
                    reject(error);
                })
            })
        },
        
        findByMemberId({commit}, payload){
            return new Promise((resolve, reject) => {
                MemberApi.findByMemberId(payload)
                .then(response => {
                    commit('findByMemberId', response);
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                    console.log(error);
                })
            })
        },

        modify(context, payload){
            return new Promise((resolve, reject) => {
                MemberApi.modify(payload)
                .then(response => {
                    resolve(response);
                })
                .catch(error => {
                    console.log(error);
                    reject(error);
                })
            })
        },

        remove({dispatch, commit}, payload){
            return new Promise((resolve, reject) => {
                MemberApi.remove(payload)
                .then(response =>{
                    commit('remove');
                    dispatch('destoryToken');
                    resolve(response);
                })
                .catch(error => {
                    console.log(error);
                    reject(error);
                })
            })
        }
    }
}

export default memberStore
