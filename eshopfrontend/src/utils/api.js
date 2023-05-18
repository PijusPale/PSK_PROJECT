import axios from "axios";

const API_URL = "http://localhost:9999/e-shop";

function getProducts() {
  return axios.get(`${API_URL}/products`, {
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
  })
    .then((response) => response.data)
    .catch((error) => {
      console.error("Error fetching products:", error);
    });
}

async function postOrder(orderData) {
  try {
    const config = {
      headers: {
        'Content-Type': 'application/json'
      }
    };

    const response = await axios.post(`${API_URL}/order`, orderData, config);
    return response.data;
  } catch (error) {
    console.error('Error creating order:', error);
    throw error;
  }
}

async function putOrder(orderData,orderId) {
  try {
    const config = {
      headers: {
        'Content-Type': 'application/json'
      }
    };
    const response = await axios.put(`${API_URL}/order/${orderId}`, orderData, config);
    return response.data;
  } catch (error) {
    console.error('Error creating order:', error);
    throw error;
  }
}

function getOrderById(orderId) {
  return axios.get(`${API_URL}/order/${orderId}`, {
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Accept": "application/json",
        "Content-Type": "application/json",
      },
  })
    .then((response) => response.data) 
    .catch((error) => {
      console.error("Error fetching products:", error);
    });
}

const api = {
    getProducts,
    postOrder,
    putOrder,
    getOrderById,
  };
  
  export default api;
  