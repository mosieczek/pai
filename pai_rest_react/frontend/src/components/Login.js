import React, {useState, useEffect} from 'react'
import { Redirect, Link } from 'react-router-dom'
import { login } from '../services/authService';
export const Login = () => {

    const [ username, setUsername ] = useState('');
    const [ password, setPassword ] = useState('');
    const [ errors, setErrors ] = useState({});

    const handleLogin = async (e) => {
        try {
            const { data } = await login({username: username, password: password});
            console.log(data)
            window.localStorage.setItem("token", data);
            window.location = "/";
        } catch (error) {
            alert('Nie udało się zalogować')
            console.log(error);
            const errorsVal = { ...errors };
            errorsVal.username = error.response.data;
            errorsVal.password = error.response.data;
            setErrors(errorsVal)
        }
    };
    return (
        <div className='App-body'>
            <h1>Logowanie</h1>
                <form className="form-signin" onSubmit={handleLogin}>
                    <div className="input-group mb-4">
                        <input variant="standard"
                        className="form-control"
                        type="login"
                        value={username}
                        onChange = {(e) => setUsername(e.target.value)}
                        placeholder = "username"
                        required
                        />
                    </div>
                    <div className="input-group mb-4">
                        <input placeholder="Hasło" variant="standard"
                        className="form-control"
                        type="password"
                        value={password}
                        onChange = {(e) => setPassword(e.target.value)}
                        placeholder = "Password"
                        required
                        />
                    </div>
                    <div>
                        <button className="btn btn-lg btn-primary btn-block" type="submit">Zaloguj się</button>
                    </div>
                </form>
                <div>
                    <Link to="/register">Nie mam konta</Link>
                </div>
            
        </div>
    );
};
