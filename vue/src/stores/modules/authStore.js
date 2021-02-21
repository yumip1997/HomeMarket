import {LoginApi} from '@/api'

const authStore = {
    state : {
        loggedIn : false,
        loggedInMember : null,
        token : localStorage.getItem('accessToken') || null,
        },
    getters : {
        loggedIn(state){
            return state.token != null;
        }
    },
    mutations : {
        retrieveToken(state, token){
            state.token = token;
        }
    },
    actions : {
        retrieveToken(context, credentials){
            return new Promise((resolve, reject) => {
                LoginApi.login(credentials.memberId, credentials.password)
                .then(response =>{
                    const token = response.accessToken;
                    localStorage.setItem('accessToken', token);
                    context.commit('retrieveToken', token);
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

export default authStore