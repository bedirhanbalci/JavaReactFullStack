import { cartReducer } from "./slices/cartSlice";
import { combineReducers, configureStore } from "@reduxjs/toolkit";

export const rootReducer = combineReducers({
  cart: cartReducer,
});

export const store = configureStore({
  reducer: rootReducer,
});
