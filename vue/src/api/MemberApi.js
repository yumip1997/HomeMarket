import AxiosClient from './AxiosClient';

class MemberApi{
    constructor(){
        this.client = new AxiosClient('/member');
    }

    async register(member){
        return this.client.post('/create', member);
    }

    async findById(memberId){
        const data = (await this.client.get('/retrieveById', {memberId : memberId})).data;
        return data;
    }

    async modify(member){
        return this.client.put('/update', member);
    }

    async delete(memberId){
        return this.client.delete('/delete', {memberId : memberId});
    }
}

const instance = new MemberApi();

export default instance;