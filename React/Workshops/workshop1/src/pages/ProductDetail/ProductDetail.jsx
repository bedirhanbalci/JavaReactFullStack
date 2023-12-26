import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function ProductDetail() {
  const { id } = useParams();

  const [product, setProduct] = useState({});

  useEffect(() => {
    fetchSingleProduct();
  }, []);

  const fetchSingleProduct = async () => {
    try {
      let response = await axios.get(`https://dummyjson.com/products/${id}`);
      setProduct(response.data);
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center">
      <div className="col-12 col-md-4 mt-5 card">
        <img src={product.thumbnail} className="card-img-top" alt="..." />
        <div className="card-body">
          <h5 className="card-title">{product.title}</h5>
          <p className="card-text">{product.description}</p>
          <p className="card-text">
            <b>Price: </b>
            {product.price}
          </p>
          <p className="card-text">
            <b>Rating: </b>
            {product.rating}
          </p>
          <p className="card-text">
            <b>Stock: </b>
            {product.stock}
          </p>
        </div>
      </div>
    </div>
  );
}

export default ProductDetail;
