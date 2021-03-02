import {MemberApi} from '@/api'

const memberStore = {
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
        
        findByMemberId(context, payload){
            return new Promise((resolve, reject) => {
                MemberApi.findByMemberId(payload)
                .then(response => {
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
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

        remove({commit, dispatch}, payload){
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
