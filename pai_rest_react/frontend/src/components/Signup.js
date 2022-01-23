import React, {useState, useEffect} from 'react'
import { register } from '../services/userService';


export const Signup = () => {
    const [ username, setUsername ] = useState('');
    const [ password, setPassword ] = useState('');
    const [ errors, setErrors ] = useState({});

    const handleRegister = async () => {
        try {
            await register({username: username, password: password});
            window.location = "/";
        } catch (error) {
            console.log(error);
        }
    };
    return (
        <div className='App-body'>
            <h1>Rejestracja</h1>
                <form className="form-signin" onSubmit={handleRegister}>
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
        </div>
    );
};
