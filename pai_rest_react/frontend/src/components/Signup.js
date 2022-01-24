import React, {useState, useEffect} from 'react'
import { register } from '../services/userService';
import lockedFridge from '../img/lockedFridge.jpg'



export const Signup = () => {
    const [ username, setUsername ] = useState('');
    const [ password, setPassword ] = useState('');
    const [ name, setName ] = useState('');
    const [ surname, setSurname] = useState('');
    const [ errors, setErrors ] = useState({});

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            const registerAction = await register({username: username, password: password, name: name, surname:surname});
            if(registerAction.data === 'Użytkownik istnieje'){
                alert(registerAction.data)
            }
            else{
                alert(registerAction.data)
                window.location = "/";
            }

        } catch (error) {
            console.log(error);
            alert('Podaj poprawny login i hasło')
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
            <h1>Rejestracja</h1>
                <form className="form-signin" onSubmit={handleRegister}>
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
                        <input variant="standard"
                        className="form-control"
                        type="login"
                        value={name}
                        onChange = {(e) => setName(e.target.value)}
                        placeholder = "Imię"
                        required
                        />
                    </div>
                    <div className="input-group mb-4">
                        <input variant="standard"
                        className="form-control"
                        type="login"
                        value={surname}
                        onChange = {(e) => setSurname(e.target.value)}
                        placeholder = "Nazwisko"
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
                        <button className="btn btn-lg btn-primary btn-block" type="submit">Zarejestruj się</button>
                    </div>
                </form>
        </div>
    );
};
