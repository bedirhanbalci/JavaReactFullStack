import { Link } from "react-router-dom";

export default function NoMatch() {
  return (
    <div className="row my-5">
      <div className="col text-center">
        <h4 className="display-5">Aradığınız sayfa bulunamadı.</h4>
        <Link to="/">Ana Sayfaya Dön!</Link>
      </div>
    </div>
  );
}
