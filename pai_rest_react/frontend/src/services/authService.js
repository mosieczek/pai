import axios from "axios";
import jwtDecode from "jwt-decode";
const apiUrl = process.env.REACT_APP_API_URL;

export function login(data) {
    console.log(data)
    return axios.post(`${apiUrl}/login`, data);
}

export function getCurrentUser() {
    try {
        const token = localStorage.getItem("token");
        return jwtDecode(token);
    } catch (error) {
        console.log(error)
        return null;
    }
}

export function logout() {
    localStorage.removeItem("token");
}