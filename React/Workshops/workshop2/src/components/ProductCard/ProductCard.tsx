import { HttpStatusCode } from "axios";
import { Link } from "react-router-dom";
import { ProductModel } from "../../models/responses/ProductModel";
import ProductService from "../../services/ProductService";

type Props = {
  product: ProductModel;
  onDelete: (id: number) => void;
  title?: string;
};

const ProductCard = (props: Props) => {
  const deleteProduct = async () => {
    try {
      let response = await ProductService.delete(props.product.id);
      if (response.status == HttpStatusCode.Ok) {
        props.onDelete(props.product.id);
        alert("Veri başarıyla silindi.");
      }
    } catch (error) {
      alert("Veri silinemedi!");
    }
  };

  return (
    <div>
      <div className="card" style={{ height: "550px" }}>
        <img
          src={props.product.thumbnail}
          className="card-img-top"
          alt="..."
          style={{ height: "250px" }}
        />
        <div className="card-body d-flex flex-column justify-content-between">
          <h5 className="card-title">{props.product.title}</h5>
          <p className="card-text">{props.product.description}</p>
          <div>
            <Link
              to={`/product-detail/${props.product.id}`}
              className="btn btn-primary col-5"
            >
              Details
            </Link>
            <button
              onClick={() => {
                deleteProduct();
              }}
              className="btn btn-danger offset-2 col-5"
            >
              Delete
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
