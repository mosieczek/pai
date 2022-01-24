import axios from 'axios';
import React, {useState} from 'react'
import { Link } from 'react-router-dom'
import { login } from '../services/authService';
import lockedFridge from '../img/lockedFridge.jpg'

const apiUrl = process.env.REACT_APP_API_URL;

export const Login = () => {

    const [ username, setUsername ] = useState('');
    const [ password, setPassword ] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const { data } = await login({username: username, password: password}) 
                window.localStorage.setItem("token", data.token);
                window.location = "/";
                
        } catch (error) {
            console.log(error);
            alert('Nie udało się zalogować, wprowadź poprawne dane')
        }
    };
    return (
        <div className='App-body' 
            style={{
                backgroundImage: `url(${lockedFridge})`,
                backgroundRepeat: 'no-repeat',
                backgroundAttacjment: 'fixed',
                backgroundSize: 'cover'
             }}>
            <h1>Logowanie</h1>
                <form className="form-signin" onSubmit={handleLogin}>
                    <div className="input-group mb-4">
                        <input variant="standard"
                        className="form-control"
                        type="login"
                        value={username}
                        onChange = {(e) => setUsername(e.target.value)}
                        placeholder = "Username"
                        required
                        />
                    </div>
                    <div className="input-group mb-4">
                        <input placeholder="Hasło" variant="standard"
                        className="form-control"
                        type="password"
                        value={password}
                        onChange = {(e) => setPassword(e.target.value)}
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
