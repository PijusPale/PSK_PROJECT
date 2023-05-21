import React, { useState, useEffect } from 'react';
import ProductList from '../components/ProductList';
import api from "./../utils/api";

const Home = () => {
  const [products, setProducts] = useState([]);
  const [cartItems, setCartItems] = useState([]);
  const [ordreId, setOrderId] = useState(-1);

  const handleAddToCart = (product) => {
    setCartItems([...cartItems, product]);
  };
  

  useEffect(() => {
    const user_id = 1;
    console.log(cartItems);
    if (cartItems.length === 1 ){
      const productIds = cartItems.map((item) => item.id);
      const totalPrice = cartItems[0].price;
      const orderData = {
        productIds: productIds,
        userId: user_id, // Replace with the actual user ID
        orderStatus: 'ACCEPTED',
        price: totalPrice,
        shippingAddress: 'Lietuva, Vilnius, Gedimino pr. 1'
      };
      api.postOrder(orderData)
      .then(data => {
        setOrderId(data.id);
      })
      .catch(error => {
        console.log(error);
      });
    }
    else if(cartItems.length > 1){ 
      const productIds = cartItems.map((item) => item.id);
      const totalPrice = cartItems.reduce((total, item) => total + item.price, 0);
      const orderData = {
        productIds: productIds,
        userId: user_id, // Replace with the actual user ID
        orderStatus: 'ACCEPTED',
        price: totalPrice,
        shippingAddress: 'Lietuva, Vilnius, Gedimino pr. 1'
      };
        
      api.putOrder(orderData,ordreId)
      .then(data => {
        console.log(data);
      })
      .catch(error => {
        console.log(error);
      });

    }
  }, [cartItems]);

  useEffect(() => {
    api.getProducts().then((data) => {
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
            quantity={product.quantity}
            picturePath={product.picturePath}
            addToCart={() => handleAddToCart(product)}
          />
      ))}
      </main>
    </div>
  );
}

export default Home;