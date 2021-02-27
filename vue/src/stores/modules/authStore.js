import {LoginApi} from '@/api'

const authStore = {
    state : {
        accessToken : localStorage.getItem('accessToken') || null,
        loggedInMember : localStorage.getItem('loggedInMember') || null,
    },

    getters : {
        isLoggedIn(state){
            return state.accessToken != null;
        },
        getLoggedInMember(state){
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
        retrieveToken({commit}, payload){
            return new Promise((resolve, reject) => {
                LoginApi.login(payload.memberId, payload.password)
                .then(response =>{
                    const accessToken = response.accessToken;
                    const memberId = response.memberId;

                    localStorage.setItem('accessToken', accessToken);
                    localStorage.setItem('loggedInMember', memberId);

                    commit('retrieveToken', {
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
        destoryToken({commit, state}){
            if(state.accessToken){
                //백엔드 단에서 logout 로직 처리 필요!
                localStorage.removeItem('accessToken');
                localStorage.removeItem('loggedInMember');

                commit('destoryToken');
            }
        }
    }
}

export default authStore