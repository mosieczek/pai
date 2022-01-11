import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes, Link } from 'react-router-dom'
import { Home } from './pages/Home';
import { OtherHome } from './pages/OtherHome';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <div>
          <nav>
            <Link to="/">Home</Link>
            <Link to="/home">Home2</Link>
          </nav>
          <Routes>
            <Route path="/home" element={<Home/>}/>
            <Route path="/" element={<OtherHome/>}/>
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
