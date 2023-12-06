package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Corporate;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CorporateRepository extends JpaRepository<Corporate, Integer> {

    List<Corporate> findByCompanyName(String companyName);

    @Query("Select new com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse" +
            " (c.id, c.companyName, c.contactName, c.contactTitle, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(cus.id, cus.phone, cus.email, cus.address))" +
            "From Corporate c INNER JOIN c.customer cus WHERE c.contactTitle ILIKE '%Manager%'")
    List<GetListCorporateResponse> findByContactTitleILike();

    @Query("Select new com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse" +
            " (c.id, c.companyName, c.contactName, c.contactTitle, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(cus.id, cus.phone, cus.email, cus.address))" +
            "From Corporate c INNER JOIN c.customer cus WHERE c.companyName = 'Tobeto' AND c.contactTitle = 'Sales Manager'")
    List<GetListCorporateResponse> findByCompanyNameAndContactTitle();

    @Query("Select new com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse" +
            " (c.id, c.companyName, c.contactName, c.contactTitle, new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(cus.id, cus.phone, cus.email, cus.address))" +
            "From Corporate c INNER JOIN c.customer cus ORDER BY c.contactName ASC")
    List<GetListCorporateResponse> findOrderByContactName();

}
