import {LoginApi} from '@/api'

const authStore = {
    state : {
        accessToken : localStorage.getItem('accessToken') || null,
        loggedInMemberId : localStorage.getItem('loggedInMemberId') || null,
    },

    getters : {
        isLoggedIn(state){
            return state.accessToken != null;
        },
        getLoggedInMemberId(state){
            return state.loggedInMemberId;
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
        retrieveToken({commit}, payload){
            return new Promise((resolve, reject) => {
                LoginApi.login(payload.memberId, payload.password)
                .then(response =>{
                    const accessToken = response.accessToken;
                    const memberId = response.memberId;

                    localStorage.setItem('accessToken', accessToken);
                    localStorage.setItem('loggedInMemberId', memberId);

                    commit('retrieveToken', {
                        accessToken : accessToken,
                        loggedInMemberId :  memberId
                    });
                    resolve(response);
                })
                .catch(error => {
                    reject(error);
                })
            })
        },
        destoryToken({commit, state}){
            if(state.accessToken){
                //백엔드 단에서 logout 로직 처리 필요!
                localStorage.removeItem('accessToken');
                localStorage.removeItem('loggedInMemberId');

                commit('destoryToken');
            }
        }
    }
}

export default authStore