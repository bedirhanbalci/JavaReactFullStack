import { ErrorMessage, Field } from "formik";

type Props = {
  label: string;
  name: string;
};

const FormikSelect = (props: Props) => {
  const colorOptions = [
    { label: "Bir renk seçin!", value: "0" },
    { label: "Kırmızı", value: "1" },
    { label: "Beyaz", value: "2" },
    { label: "Siyah", value: "3" },
  ];

  return (
    <div className="mb-3">
      <label className="form-label">{props.label}</label>
      <Field name={props.name} as="select" className="form-control">
        {colorOptions.map(option => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </Field>
      <ErrorMessage name={props.name}>
        {message => <p className="badge small bg-danger text-end">{message}</p>}
      </ErrorMessage>
    </div>
  );
};

export default FormikSelect;
