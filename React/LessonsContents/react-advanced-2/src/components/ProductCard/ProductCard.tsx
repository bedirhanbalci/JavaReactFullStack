import { ProductModel } from "../../models/responses/ProductModel";
import { Link } from "react-router-dom";
import ProductService from "../../services/productService";
import { HttpStatusCode } from "axios";
import { useDispatch } from "react-redux";
import { addToCart } from "../../store/slices/cartSlice";

type Props = {
  product: ProductModel;
  onDelete: (id: number) => void;
  title?: string; // (opsiyonel)
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

  const dispatch = useDispatch();
  const addProductToCart = () => {
    dispatch(addToCart({ product: props.product }));
  };

  return (
    <div className="card">
      <img src={props.product.thumbnail} className="card-img-top" alt="..." />
      <div className="card-body">
        <h5 className="card-title">{props.product.title}</h5>
        <p className="card-text">{props.product.description}</p>
        <p>{props.product.price} ₺</p>
        <Link
          to={"/product-detail/" + props.product.id}
          className="btn btn-primary"
        >
          Details
        </Link>
        <button onClick={addProductToCart} className="btn btn-secondary">
          Sepete Ekle
        </button>
        <button
          onClick={() => {
            deleteProduct();
          }}
          className="btn btn-danger"
        >
          Sil
        </button>
      </div>
    </div>
  );
};

export default ProductCard;
