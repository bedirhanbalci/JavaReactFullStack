import { Formik, Form } from "formik";
import * as Yup from "yup";
import FormikInput from "../../components/FormikInput/FormikInput";
import FormikSelect from "../../components/FormikSelect/FormikSelect";
import { passwordRule } from "../../utils/validation/customValidationRules";

type Props = {};

interface ProductAddForm {
  brand: string;
  description: string;
  price: number;
  title: string;
  colorId: number;
}

const ProductAdd = (props: Props) => {
  const initialValues: ProductAddForm = {
    brand: "",
    description: "",
    price: 0,
    title: "",
    colorId: 0,
  };

  const validationSchema = Yup.object({
    brand: Yup.string()
      .required("Marka alanı zorunludur.")
      .min(2, "Marka en az 2 haneden oluşmalıdır.")
      .max(50, "Marka en fazla 50 haneden oluşmalıdır.")
      .test(
        "is strong",
        "Bu alan en az 1 büyük harf, 1 küçük harf ve 1 numerik değer içermelidir!",
        passwordRule
      ),
    description: Yup.string()
      .required("Açıklama alanı zorunludur.")
      .min(5, "Açıklama en az 5 haneden oluşmalıdır.")
      .max(250, "Açıklama en fazla 250 haneden oluşmalıdır."),
    price: Yup.number()
      .required("Fiyat boş geçilemez!")
      .min(1, "Fiyat en az 1 olmalıdır!"),
    title: Yup.string()
      .required("Başlık alanı zorunludur.")
      .min(2, "Başlık en az 2 haneden oluşmalıdır.")
      .max(50, "Başlık en fazla 50 haneden oluşmalıdır."),
    colorId: Yup.number()
      .required("Renk seçimi yapınız.")
      .min(1, "Geçerli bir renk seçiniz!"),
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
          <FormikInput name="brand" label="Marka" />
          <FormikInput name="description" label="Ürün Açıklaması" />
          <FormikInput name="price" label="Ürün Fiyatı" type="number" />
          <FormikInput name="title" label="Ürün Adı" />
          <FormikSelect name="colorId" label="Renk" />

          <button type="submit" className="btn btn-primary">
            Save
          </button>
        </Form>
      </Formik>
    </div>
  );
};

export default ProductAdd;
