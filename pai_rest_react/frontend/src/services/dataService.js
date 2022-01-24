import axios from "axios";
import { getCurrentUser } from "./authService";
const apiUrl = process.env.REACT_APP_API_URL_USER;
const token = localStorage.getItem("token");

export function dataTest() {
    const currentUser = getCurrentUser();
    const username = currentUser.sub
    return axios.get(`${apiUrl}/get/${username}`, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    });
}

export function getProducts() {
    const currentUser = getCurrentUser();

    const username = currentUser.sub

    return axios.get(`${apiUrl}/getProducts/${username}`, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    });
}

export function addProduct(data) {

    return axios.post(`${apiUrl}/addProduct`, data, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
}
export function updateProduct(id, product) {

    return axios.put(`${apiUrl}/updateProduct/${id}`, product, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
}

export function deleteProduct(data) {
    return axios.delete(`${apiUrl}/deleteProduct/${data}`, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
}