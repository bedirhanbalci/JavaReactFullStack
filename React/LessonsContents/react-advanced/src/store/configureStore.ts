import { rootReducer } from "./rootReducer";
import { configureStore } from "@reduxjs/toolkit";

// export const configureStore = () => {
//   return createStore(rootReducer);
// };

export default configureStore({
  reducer: {
    createStore: rootReducer,
  },
});
