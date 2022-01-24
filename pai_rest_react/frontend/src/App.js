import './App.css';
import { Login } from './components/Login';
import { Home } from './components/Home';
import { Signup } from './components/Signup';
import { Logout } from './components/Logout';
import { Fridge } from './components/Fridge';
import { HomeAuth } from './components/HomeAuth';
import { BrowserRouter, Route, Routes, Link, NavLink } from 'react-router-dom';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { useState, useEffect } from 'react';

function App() {
  const [isAuth, setIsAuth] = useState(false)
  const token = localStorage.getItem("token");
  useEffect(() => {
    if(token === null){
      setIsAuth(false)
    }else{
      setIsAuth(true)
    }
  },[token])
  if(isAuth){
    return (
      <div className="App">
        <BrowserRouter>
          <div>
            <Navbar>
              <Nav>
                <NavLink className = "btn btn-light btn-outline-primary" to="/">Home</NavLink>
                <NavLink className = "btn btn-light btn-outline-primary" to="/fridge">Lodówka</NavLink>

                <NavLink className = "btn btn-light btn-outline-primary" to="/logout">Wyloguj</NavLink>
              </Nav>
            </Navbar>
            <Routes>
              <Route path="/fridge" element={<Fridge/>}/>
              <Route path="/logout" element={<Logout/>}/>
              <Route path="/" element={<HomeAuth/>}/>
            </Routes>
          </div>
        </BrowserRouter>
        <footer>
          Adriana Osmulska Projektowanie Aplikacji Internetowych 2022
        </footer>
      </div>
    );
  }else{
    return (
      <div className="App">
        <BrowserRouter>
          <div>
            <Navbar>
              <Nav>
                <NavLink className = "btn btn-light btn-outline-primary" to="/">Home</NavLink>
                <NavLink className = "btn btn-light btn-outline-primary" to="/login">Logowanie</NavLink>
                <NavLink className = "btn btn-light btn-outline-primary" to="/register">Rejestracja</NavLink>

              </Nav>
            </Navbar>
            <Routes>
              <Route path="/login" element={<Login/>}/>
              <Route path="/register" element={<Signup/>}/>

              <Route path="/" element={<Home/>}/>
            </Routes>
          </div>
        </BrowserRouter>
        <footer>
          Adriana Osmulska Projektowanie Aplikacji Internetowych 2022
        </footer>
      </div>
    );
  }

}

export default App;
