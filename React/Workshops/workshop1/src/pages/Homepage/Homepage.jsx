import React, { useEffect, useState } from "react";
import ProductCard from "../../components/ProductCard/ProductCard";
import axios from "axios";

export default function Homepage() {
  // const myAsyncFunction = () => {
  //   return new Promise((resolve, reject) => {
  //     resolve("HTTP VERİSİ");
  //   });
  // };

  // useEffect(() => {
  //   makeAsyncCall();
  //   makeHttpCall();
  // }, []);

  // const makeAsyncCall = async () => {
  //   // myAsyncFunction()
  //   //   .then(response => {
  //   //     console.log("İşlem başarılı cevap:", response);
  //   //   }) // async işlem başarılı ise (resolve edildi ise)
  //   //   .catch(error => {
  //   //     console.log("İşlem başarısız cevap:", error);
  //   //   }) // async işlem başarısız ise (reject edildi ise)
  //   //   .finally(() => {
  //   //     console.log("İşlem bitti");
  //   //   }); // her halükarda en son çalışır

  //   //ES2017 async-await
  //   try {
  //     let response = await myAsyncFunction();
  //     console.log(response);
  //   } catch (e) {
  //     console.log(e);
  //   }
  // };

  // const makeHttpCall = async () => {
  //   // fetch("https://dummyjson.com/products")
  //   //   .then(response => response.json())
  //   //   .then(json => console.log(json))
  //   //   .catch(err => console.log(err));

  //   let response = await fetch("https://dummyjson.com/products");
  //   let json = await response.json();
  //   console.log(json);
  // };

  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    let response = await axios.get("https://dummyjson.com/products");
    setProducts(response.data.products);
  };

  return (
    <div className="container mt-5">
      <div className="row">
        {products.map(product => (
          <div key={product.id} className="col-lg-3 col-md-6 col-12 mb-5">
            <ProductCard product={product} />
          </div>
        ))}
      </div>
    </div>
  );
}
