import AxiosClient from './AxiosClient'

class LoginApi{
    constructor(){
        this.client = new AxiosClient('/api/homemarket/login');
    }

    async login(memberId, password){
        const data = (await this.client.post('/loginCheck',{
            memberId : memberId,
            password : password
        })).data
        return data;
    }
}

const instance = new LoginApi()

export default instance