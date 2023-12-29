import React, { useEffect, useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import { ProductModel } from "../../models/responses/ProductModel";
import ProductService from "../../services/productService";

type Props = {};

const ProductDetail = (props: Props) => {
  const params = useParams<{ id: string }>(); // location
  // const location = useLocation();    query string
  const [product, setProduct] = useState<ProductModel>();

  useEffect(() => {
    // let query = new URLSearchParams(location.search);
    if (params.id) {
      ProductService.getById(parseInt(params.id)).then(response => {
        setProduct(response.data);
      });
    }
    // console.log(query.get("abc"));
    // console.log(query.get("id"));
  }, []);

  return (
    <div>
      <p>{product?.title}</p>
    </div>
  );
};
export default ProductDetail;
