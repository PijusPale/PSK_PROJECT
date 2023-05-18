import React from "react";
import '../styles/Product.css';

const ProductList = (props) => {
  const handleAddToCart = () => {
    // Logic to add the product to the cart
    // You can implement this based on your application's requirements
    props.addToCart(props);
  };
  return (
    <div className="product">
      <h3>{props.name}</h3>
      <p>{props.description}</p>
      <p>{props.price} €</p>
      <button onClick={handleAddToCart}>Add to Cart</button>
    </div>
  );
};

export default ProductList;