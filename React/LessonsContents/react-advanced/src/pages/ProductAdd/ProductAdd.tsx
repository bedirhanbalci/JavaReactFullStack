import { Formik, Form, Field, ErrorMessage } from "formik";
import React from "react";
import * as Yup from "yup";
import { passwordRule } from "../../utils/validation/customValidationRules";
import FormikInput from "../../components/FormikInput/FormikInput";
import FormikSelect from "../../components/FormikSelect/FormikSelect";

type Props = {};

interface ProductAddForm {
  title: string;
  description: string;
  price: number;
  stock: number;
  colorId: number;
}

const ProductAdd = (props: Props) => {
  const initialValues: ProductAddForm = {
    title: "",
    description: "",
    price: 0,
    stock: 0,
    colorId: 0,
  };

  const validationSchema = Yup.object({
    title: Yup.string()
      .required("Başlık alanı zorunludur.")
      .min(2, "Başlık en az 2 haneden oluşmalıdır.")
      .max(50, "Başlık en fazla 50 haneden oluşmalıdır.")
      .test(
        "is strong",
        "Bu alan en az 1 büyük harf, 1 küçük harf ve 1 numerik değer içermelidir!",
        passwordRule
      ),
    description: Yup.string()
      .required("Açıklama alanı zorunludur.")
      .min(5, "Açıklama en az 5 haneden oluşmalıdır.")
      .max(300, "Açıklama en fazla 300 haneden oluşmalıdır."),
    price: Yup.number()
      .required("Fiyat boş geçilemez!")
      .min(1, "Fiyat en az 1 olmalıdır!"),
    stock: Yup.number()
      .required("Stok adedi boş geçilemez!")
      .integer("Geçerli bir stok adedi giriniz."),
    colorId: Yup.number()
      .required("Renk seçimi yapınız.")
      .min(1, "Geçerli bir renk giriniz!"),
  });
  return (
    <div className="container mt-5">
      <Formik
        validationSchema={validationSchema}
        initialValues={initialValues}
        onSubmit={values => {
          console.log(values);
        }}
      >
        <Form>
          <FormikInput name="title" label="Ürün Adı" />
          <FormikInput name="description" label="Ürün Açıklaması" />
          <FormikInput name="price" label="Ürün Fiyatı" type="number" />
          <FormikInput name="stock" label="Ürün Stok" type="number" />

          <Field name="colorId" className="form-select" as="select">
            <option value={0}>Bir renk seçin</option>
            <option value={1}>Kırmızı</option>
            <option value={2}>Siyah</option>
            <option value={3}>Beyaz</option>
          </Field>
          <ErrorMessage name="colorId"></ErrorMessage>

          <button type="submit" className="btn btn-primary">
            Kaydet
          </button>
        </Form>
      </Formik>
    </div>
  );
};

export default ProductAdd;
