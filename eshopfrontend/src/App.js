import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from './pages/Home';
import Cart from './pages/Cart';
import About from './pages/About';
// import Services from './pages/Services';
import Contacts from './pages/Contacts';
import Header from './components/Header';
import './styles/App.css';
import ProductForm from './pages/ProductForm';
import Faq from './pages/Faq';
import OrdersPage from './pages/OrdersPage';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <div className="MainContent">
          <Routes>
            <Route exact path="/" element={<Home/>} />
            <Route path="/cart" element={<Cart/>} />
            <Route exact path="/add-product" element={<ProductForm/>} />
            <Route exact path="/about" element={<About />} />
            <Route exact path="/faq" element={<Faq />} />
            <Route exact path="/contacts" element={<Contacts />} />
            <Route exact path="/orders" element={<OrdersPage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
