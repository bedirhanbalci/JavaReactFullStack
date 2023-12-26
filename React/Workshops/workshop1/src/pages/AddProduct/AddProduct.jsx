import axios from "axios";
import React, { useState } from "react";

function AddProduct() {
  const [form, setForm] = useState({
    brand: "",
    description: "",
    price: "",
    title: "",
  });

  const handleChangeForm = e => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAddProduct = async (e, form) => {
    e.preventDefault();
    try {
      let response = await axios.post(
        "https://dummyjson.com/products/add",
        {
          brand: form.brand,
          description: form.description,
          price: form.price,
          title: form.title,
        },
        {
          "Content-Type": "application/json",
        }
      );
      console.log(response.data);
      //   setForm({
      //     brand: "",
      //     description: "",
      //     price: "",
      //     title: "",
      //   });
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center">
      <form className="col-12 col-lg-3 col-md-8">
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">
            Brand
          </label>
          <input
            type="text"
            name="brand"
            onChange={handleChangeForm}
            value={form.brand}
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">
            Description
          </label>
          <input
            type="text"
            name="description"
            onChange={handleChangeForm}
            value={form.description}
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">
            Price
          </label>
          <input
            type="text"
            name="price"
            onChange={handleChangeForm}
            value={form.price}
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">
            Title
          </label>
          <input
            type="text"
            name="title"
            onChange={handleChangeForm}
            value={form.title}
            className="form-control"
            id="exampleInputEmail1"
            aria-describedby="emailHelp"
          />
        </div>

        <button
          onClick={e => handleAddProduct(e, form)}
          className="btn btn-primary"
        >
          Submit
        </button>
      </form>
    </div>
  );
}

export default AddProduct;
