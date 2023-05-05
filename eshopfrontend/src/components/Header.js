import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Header.css';

function Header() {
  return (
    <header>
      <nav>
        <h1><Link to="/">PASSATSHOP</Link></h1>
        <ul>
          <li><Link to="/about">About</Link></li>
          <li><Link to="/services">Services</Link></li>
          <li><Link to="/faq">FAQ</Link></li>
          <li><Link to="/contacts">Contacts</Link></li>
          <li><Link to="/cart">Cart</Link></li>
        </ul>
      </nav>
    </header>
  );
}

export default Header;