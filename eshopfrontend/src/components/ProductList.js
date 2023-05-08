import React from "react";
import '../styles/Product.css';

const ProductList = (props) => {
  return (
    <div class="product">
      <h3>{props.name}</h3>
      <p>{props.description}</p>
      <p>{props.price}</p>
    </div>
  );
};

export default ProductList;