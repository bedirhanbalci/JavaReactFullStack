import React, { useContext } from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext";

type Props = {};

const Navbar = (props: Props) => {
  const cartState = useSelector((state: any) => state.cart);
  console.log(cartState);

  const authContext: any = useContext(AuthContext);
  console.log(authContext);

  return (
    <nav
      className="navbar bg-dark border-bottom border-body navbar-expand-lg bg-body-tertiary"
      data-bs-theme="dark"
    >
      <div className="container-fluid">
        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link className="nav-link active" aria-current="page" to={"/"}>
                Ana Sayfa
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/product-add"}>
                Ürün Ekle
              </Link>
            </li>
            {!authContext.isAuthenticated && (
              <li className="nav-item">
                <button
                  className="nav-link"
                  onClick={() => {
                    authContext.setIsAuthenticated(true);
                  }}
                >
                  Giriş Yap
                </button>
              </li>
            )}
            {authContext.isAuthenticated && (
              <li className="nav-item">
                <Link className="nav-link" to={"/product-add"}>
                  Hoşgeldiniz
                </Link>
              </li>
            )}
          </ul>
          <form className="d-flex" role="search">
            <input
              className="form-control me-2"
              type="search"
              placeholder="Arama"
              aria-label="Search"
            />
            <button className="btn btn-outline-success" type="submit">
              Arama
            </button>
          </form>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
