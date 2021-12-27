import React, { useState, useEffect } from 'react'
import axios from 'axios'

export const useGetStudents = () => {
    const [result, setResult] = useState(null)
    
    useEffect(() =>{
        axios.get('/students/all',{})
        .then((response) => {
            setResult(response.data);
        });
    }, [])
    return result
}
