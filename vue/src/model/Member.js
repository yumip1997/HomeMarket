class Member{
    constructor(memberId, name, password, email, address, joinDate, auth){
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.joinDate = joinDate;
        this.auth = auth;
    }
}

export default Member;