import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ProductService from "../../services/ProductService";
import { ProductModel } from "../../models/responses/ProductModel";

type Props = {};

const ProductDetail = (props: Props) => {
  const params = useParams<{ id: string }>();

  const [product, setProduct] = useState<ProductModel>();

  useEffect(() => {
    if (params.id) {
      ProductService.getById(parseInt(params.id)).then(response => {
        setProduct(response.data);
      });
    }
  }, []);

  return (
    <div className="d-flex justify-content-center align-items-center">
      <div className="col-12 col-md-4 mt-5 card">
        <img src={product?.thumbnail} className="card-img-top" alt="..." />
        <div className="card-body">
          <h5 className="card-title">{product?.title}</h5>
          <p className="card-text">{product?.description}</p>
          <p className="card-text">
            <b>Price: </b>
            {product?.price}
          </p>
          <p className="card-text">
            <b>Rating: </b>
            {product?.rating}
          </p>
          <p className="card-text">
            <b>Stock: </b>
            {product?.stock}
          </p>
        </div>
      </div>
    </div>
  );
};

export default ProductDetail;
