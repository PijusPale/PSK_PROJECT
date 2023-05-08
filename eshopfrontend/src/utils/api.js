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

const api = {
    getProducts,
  };
  
  export default api;
  