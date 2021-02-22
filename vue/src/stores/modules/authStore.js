import {LoginApi} from '@/api'

const authStore = {
    state : {
        accessToken : localStorage.getItem('accessToken') || null,
        loggedInMember : localStorage.getItem('loggedInMember') || null
    },

    getters : {
        loggedIn(state){
            return state.accessToken != null;
        },
        loggedInMember(state){
            return state.loggedInMember;
        }
    },
    mutations : {
        retrieveToken(state, payload) {
            state.accessToken = payload.accessToken;
            state.loggedInMember = payload.loggedInMember;
        },
        destoryToken(state){
            state.accessToken = null;
            state.loggedInMember = null;
        }
    },
    actions : {
        retrieveToken(context, payload){
            return new Promise((resolve, reject) => {
                LoginApi.login(payload.memberId, payload.password)
                .then(response =>{
                    const accessToken = response.accessToken;
                    const memberId = response.memberId;

                    localStorage.setItem('accessToken', accessToken);
                    localStorage.setItem('loggedInMember', memberId);

                    context.commit('retrieveToken', {
                        accessToken : accessToken,
                        loggedInMember :  memberId
                    });
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                })
            })
        },
        destoryToken(context){
            if(context.getters.loggedIn){
                //백엔드 단에서 logout 기능 추가 필요!!
                localStorage.removeItem('accessToken');
                localStorage.removeItem('memberId');

                context.commit('destoryToken');
            }
        }
    }
}

export default authStore