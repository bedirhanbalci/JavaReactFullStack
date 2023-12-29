import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import "bootstrap/dist/css/bootstrap.css";
import Homepage from "./pages/Homepage/Homepage";
import About from "./pages/About/About";
import Navbar from "./components/Navbar/Navbar";
import AddProduct from "./pages/AddProduct/AddProduct";
import ProductDetail from "./pages/ProductDetail/ProductDetail";
import { ReactElement } from "react";
import NoMatch from "./pages/NoMatch/NoMatch";

function App(): ReactElement {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Homepage />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/add-product" element={<AddProduct />}></Route>
          <Route path="/product-detail/:id" element={<ProductDetail />}></Route>
          <Route path="*" element={<NoMatch />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
