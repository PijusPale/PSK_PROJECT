import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from './pages/Home';
// import About from './pages/About';
// import Services from './pages/Services';
// import FAQ from './pages/FAQ';
// import Contacts from './pages/Contacts';
import Header from './components/Header';
import './styles/App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <div className="MainContent">
          <Routes>
            <Route exact path="/" element={<Home/>} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
