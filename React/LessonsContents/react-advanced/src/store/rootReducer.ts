import { combineReducers } from "@reduxjs/toolkit";
import { cartSlice } from "./slice/cartSlice";

export const rootReducer = combineReducers({
  cart: cartSlice,
});
