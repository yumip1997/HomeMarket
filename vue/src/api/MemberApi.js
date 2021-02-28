import AxiosClient from './AxiosClient'

class MemberApi{
    constructor(){
        this.client = new AxiosClient('/api/homemarket/member')
    }

    async register(member){ 
        const status = (await this.client.post('/create', member)).status
        return status;
    }

    async findByMemberId(memberId){
        const data = (await this.client.get('/retrieveById', {
            memberId : memberId
        })).data
        return data;
    }

    async modify(member){
        const status = (await this.client.put('/update', member)).status;
        return status;
    }

    async remove(memberId){
        const status = (await this.client.delete('/delete', {
            memberId : memberId
        })).status
        return status;
    }
}

const instance = new MemberApi();

export default instance;