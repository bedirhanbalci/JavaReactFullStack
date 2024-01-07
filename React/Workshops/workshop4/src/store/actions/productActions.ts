import { ProductAddForm } from "../../pages/ProductAdd/ProductAdd";

export const addProduct = (product: ProductAddForm) => {
  console.log("Product added:", product);
  return {
    type: "ADD_PRODUCT",
    payload: product,
  };
};
