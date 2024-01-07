import { ProductAddForm } from "../../pages/ProductAdd/ProductAdd";

interface State {
  products: ProductAddForm[];
}

const initialState: State = {
  products: [],
};

const productReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case "ADD_PRODUCT":
      return {
        ...state,
        products: [...state.products, action.payload],
      };
    default:
      return state;
  }
};

export default productReducer;
