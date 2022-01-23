import React from 'react';
import axios from "axios";
import jwtDecode from "jwt-decode";


import { getCurrentUser } from './authService';
const apiUrl = process.env.REACT_APP_API_URL_USER;


export function dataTest(data) {
    const token = localStorage.getItem("token");

    // const token = getCurrentUser();
    console.log(token)


    return axios.get(`${apiUrl}/hello`, data, {
        headers: {
            "Authorization": `Bearer ${token}`
        }
    });
}