class Member {
    constructor(memberId, name, password, email, addresses, joinDate, roles){
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.addresses = addresses;
        this.email = email;
        this.joinDate = joinDate;
        this.roles =  roles;

    }
}

export default Member;