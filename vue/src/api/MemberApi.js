import AxiosClient from './AxiosClient'

class MemberApi{
    constructor(){
        this.client = new AxiosClient('/api/homemarket/member')
    }

    async register(member){ 
        console.log(member)
        const data = await this.client.post('/create', member)
        return data;
    }

    async findByMemberId(memberId){
        const data = (await this.client.get('/retrieveById', {
            memberId : memberId
        })).data
        return data
    }

    async modify(member){
        return this.client.put('/update', member)
    }

    async remove(memberId){
        return this.client.delete('/delete', {
            memberId : memberId
        })
    }
}

const instance = new MemberApi();

export default instance;