import React, { useEffect, useState } from "react";
import api from "./../utils/api";
import "./../styles/Cart.css";

const Cart = (orderId) => {
  const [cartItems, setCartItems] = useState([]);
  const [totalPrice, setTotalPrice] = useState(0);
  useEffect(() => {
    api.getOrderById(1).then((data) => {
      // Filter out duplicate products based on id
    const uniqueProducts = {};
    data.products.forEach((product) => {
      uniqueProducts[product.id] = product;
    });
    const uniqueProductArray = Object.values(uniqueProducts);
    // Calculate the total price

    setCartItems(uniqueProductArray);
    });}, []);
  useEffect(() => {
    const totalPrice = cartItems.reduce((total, item) => total + item.price, 0);
    setTotalPrice(totalPrice);
    console.log(cartItems);
  }, [cartItems]);

  return (
    <div className="cart-container">
      <h2>Cart</h2>
      {cartItems.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <table className="product-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {cartItems.map((item, index) => (
              <tr key={index}>
                <td>{item.name}</td>
                <td>{item.price}</td>
              </tr>
            ))}
            <tr className="total-row">
              <td>Total Price:</td>
              <td>{totalPrice}</td>
            </tr>
          </tbody>
        </table>
      )}
    </div>
  );
}
export default Cart;