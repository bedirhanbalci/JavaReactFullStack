import axios from "axios";
import { useState, ChangeEvent, FormEvent } from "react";

interface Form {
  brand: string;
  description: string;
  price: string;
  title: string;
}

function AddProduct() {
  const [form, setForm] = useState<Form>({
    brand: "",
    description: "",
    price: "",
    title: "",
  });

  const handleChangeForm = (e: ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleAddProduct = async (
    e: FormEvent<HTMLButtonElement>,
    formData: Form
  ) => {
    e.preventDefault();
    try {
      let response = await axios.post(
        "https://dummyjson.com/products/add",
        {
          brand: formData.brand,
          description: formData.description,
          price: formData.price,
          title: formData.title,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center">
      <form className="col-12 col-lg-3 col-md-8">
        <div className="mb-3">
          <label htmlFor="brand" className="form-label">
            Brand
          </label>
          <input
            type="text"
            name="brand"
            onChange={handleChangeForm}
            value={form.brand}
            className="form-control"
            id="brand"
            aria-describedby="brandHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">
            Description
          </label>
          <input
            type="text"
            name="description"
            onChange={handleChangeForm}
            value={form.description}
            className="form-control"
            id="description"
            aria-describedby="descriptionHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="price" className="form-label">
            Price
          </label>
          <input
            type="text"
            name="price"
            onChange={handleChangeForm}
            value={form.price}
            className="form-control"
            id="price"
            aria-describedby="priceHelp"
          />
        </div>
        <div className="mb-3">
          <label htmlFor="title" className="form-label">
            Title
          </label>
          <input
            type="text"
            name="title"
            onChange={handleChangeForm}
            value={form.title}
            className="form-control"
            id="title"
            aria-describedby="titleHelp"
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
