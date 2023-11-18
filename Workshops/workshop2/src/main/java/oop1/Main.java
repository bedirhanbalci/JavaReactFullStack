package oop1;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.setName("Delonghi Kahve Makinesi");
        product1.setDiscount(7);
        product1.setUnitPrice(7500);
        product1.setUnitsInStock(3);
        product1.setImageUrl("image1.jpg");

        Product product2 = new Product();
        product2.setName("Smeg Kahve Makinesi");
        product2.setDiscount(7);
        product2.setUnitPrice(7500);
        product2.setUnitsInStock(3);
        product2.setImageUrl("image2.jpg");

        Product product3 = new Product();
        product3.setName("Kitchen Aid Kahve Makinesi");
        product3.setDiscount(7);
        product3.setUnitPrice(7500);
        product3.setUnitsInStock(3);
        product3.setImageUrl("image3.jpg");


        Product[] products = {product1, product2, product3};

        System.out.println("<ul>");
        for (Product product : products) {
            System.out.println("<li>" + product.getName() + "</li>");
        }
        System.out.println("</ul>");

        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setId(1);
        individualCustomer.setCustomerNumber("12345");
        individualCustomer.setPhone("05052222222");
        individualCustomer.setFirstName("Bedirhan");
        individualCustomer.setLastName("Balcı");

        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setId(2);
        corporateCustomer.setCustomerNumber("54321");
        corporateCustomer.setPhone("05000000000");
        corporateCustomer.setCompanyName("Kodlama.io");
        corporateCustomer.setTaxNumber("11111111111");

        String firstName = individualCustomer.getFirstName();
        String lastName = individualCustomer.getLastName();

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

        String companyName = corporateCustomer.getCompanyName();
        String taxNumber = corporateCustomer.getTaxNumber();

        System.out.println("Company Name: " + companyName);
        System.out.println("Tax Number: " + taxNumber);

    }
}