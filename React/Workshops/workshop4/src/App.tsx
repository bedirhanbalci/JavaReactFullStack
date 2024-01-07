import { Route, Routes } from "react-router-dom";
import "./App.css";
import "bootstrap/dist/css/bootstrap.css";
import Homepage from "./pages/Homepage/Homepage";
import About from "./pages/About/About";
import Navbar from "./components/Navbar/Navbar";
import ProductDetail from "./pages/ProductDetail/ProductDetail";
import { ReactElement } from "react";
import NoMatch from "./pages/NoMatch/NoMatch";
import ProductAdd from "./pages/ProductAdd/ProductAdd";

function App(): ReactElement {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Homepage />}></Route>
        <Route path="/product-detail/:id" element={<ProductDetail />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/product-add" element={<ProductAdd />}></Route>
        <Route path="*" element={<NoMatch />} />
      </Routes>
    </>
  );
}

export default App;
