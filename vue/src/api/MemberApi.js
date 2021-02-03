import axios from 'axios';

const proxyURL =' /member'

export const registerMember = (member) => {
    return axios.post(`${proxyURL}/create`, member,
    {
		headers : { 'Access-Control-Allow-Origin': '*'}
	})
    .then(result => (result.status === 201))
}

export const findMemberById = (memberId) => {
    return axios.get(`${proxyURL}/retrieveById?memberId=${memberId}`,
    {
        headers : { 'Access-Control-Allow-Origin': '*'}
    })
    .then(result => result.data)
}

export const modifyMember = (member) => {
    return axios.post(`${proxyURL}/update`, member, {
        headers : { 'Access-Control-Allow-Origin': '*'}
    }).then(result => result)
}

export const removeMember = (memberId) => {
    return axios.delete(`${proxyURL}/delete?memberId=${memberId}`,{
        headers : { 'Access-Control-Allow-Origin': '*'}
    }).then(result => result)

}

