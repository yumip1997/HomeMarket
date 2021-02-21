import {MemberApi} from '@/api'

const memberStore = {
    state : {
        
    },
    getters : {
       
    },
    mutations : {
       
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
                    reject(error);
                    console.log(error);
                })
            })
        }
    }
}

export default memberStore
