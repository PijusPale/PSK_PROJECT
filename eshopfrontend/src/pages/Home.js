import React, { useState, useEffect } from 'react';
import ProductList from '../components/ProductList';
import api from "./../utils/api";

const Home = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    api.getProducts().then((data) => {
      console.log(data);
      setProducts(data);
    });
  }, []);
  return (
    <div>
      <main>
        <h1>Welcome to Flower Eshop!</h1>
        {products.map((product) => (
          <ProductList
            key={product.id}
            name={product.name}
            description={product.description}
            price={product.price}
          />
      ))}
      </main>
    </div>
  );
}

export default Home;