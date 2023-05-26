import React, { useState, useEffect } from 'react';
import { Table, Button } from 'react-bootstrap';
import { useAuth0 } from '@auth0/auth0-react';

const OrdersPage = () => {
  const [orders, setOrders] = useState([]);
  const { user, isAuthenticated, getAccessTokenSilently } = useAuth0();

  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const token = await getAccessTokenSilently();
        const response = await fetch('http://localhost:9999/e-shop/orders', {
            headers: {
                Authorization: `Bearer ${token}`,
            }
        });
        const data = await response.json();
        setOrders(data);
      } catch (error) {
        console.error('Error fetching orders:', error);
      }
    };

    fetchOrders();
  }, []);

  return (
    <div>
      <h1>Orders</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>User Email</th>
            <th>Order Status</th>
            <th>Price</th>
            <th>Shipping Address</th>
            <th>Products</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td>{order.id}</td>
              <td>{order.userEmail}</td>
              <td>{order.orderStatus}</td>
              <td>{order.price}</td>
              <td>{order.shippingAddress}</td>
              <td>
                {order.products.map((product) => (
                  <div key={product.id}>
                    <b>Name:</b> {product.name}
                    <br />
                    <b>Description:</b> {product.description}
                    <br />
                    <b>Price:</b> {product.price}
                    <br />
                    <b>Quantity:</b> {product.quantity}
                    <hr />
                  </div>
                ))}
              </td>
              <td>
                <Button variant="success">
                  Accept
                </Button>{' '}
                <Button variant="danger">
                  Reject
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default OrdersPage;
