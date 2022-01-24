import axios from "axios";
const apiUrl = process.env.REACT_APP_API_URL;

export function register(data) {
    try{
        return axios.post(`${apiUrl}/register`, data);
    } catch(error) {
        alert('Błąd')
        console.log(error)
    }
}