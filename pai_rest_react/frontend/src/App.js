import './App.css';
import { Login } from './components/Login';
import { Home } from './components/Home';
import { Signup } from './components/Signup';
import { Logout } from './components/Logout';
import { BrowserRouter, Route, Routes, Link, NavLink } from 'react-router-dom';
import { Navbar, Nav, Container } from 'react-bootstrap';

function App() {
  return (
    <div className="App">
    <BrowserRouter>
      <div>
        <Navbar>
          <Nav>
            <NavLink className = "btn btn-light btn-outline-primary" to="/">Home</NavLink>
            <NavLink className = "btn btn-light btn-outline-primary" to="/login">Logowanie</NavLink>
            <NavLink className = "btn btn-light btn-outline-primary" to="/signup">Rejestracja</NavLink>
            <NavLink className = "btn btn-light btn-outline-primary" to="/logout">Wyloguj</NavLink>
          </Nav>
        </Navbar>
        <Routes>
          <Route path="/login" element={<Login/>}/>
          <Route path="/signup" element={<Signup/>}/>
          <Route path="/logout" element={<Logout/>}/>
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

export default App;
