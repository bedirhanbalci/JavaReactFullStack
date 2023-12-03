package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Corporate;
import com.tobeto.rent.a.car.demo.repositories.CorporateRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CorporateService;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetAllCorporatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetCorporateResponse;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.responses.GetListCorporateResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorporateManager implements CorporateService {

    private final CorporateRepository corporateRepository;

    public CorporateManager(CorporateRepository corporateRepository) {
        this.corporateRepository = corporateRepository;
    }


    @Override
    public void add(AddCorporateRequest addCorporateRequest) {
        Corporate corporate = new Corporate();
        corporate.setCompanyName(addCorporateRequest.getCompanyName());
        corporate.setContactName(addCorporateRequest.getContactName());
        corporate.setContactTitle(addCorporateRequest.getContactTitle());
        corporate.setTaxNumber(addCorporateRequest.getTaxNumber());
        corporate.setCustomer(addCorporateRequest.getCustomerId());
        corporateRepository.save(corporate);
    }

    @Override
    public void delete(int id) {
        Corporate corporateToDelete = corporateRepository.findById(id).orElseThrow();
        corporateRepository.delete(corporateToDelete);
    }

    @Override
    public void update(UpdateCorporateRequest updateCorporateRequest) {
        Corporate corporateToUpdate = corporateRepository.findById(updateCorporateRequest.getId()).orElseThrow();
        corporateToUpdate.setCompanyName(updateCorporateRequest.getCompanyName());
        corporateToUpdate.setContactName(updateCorporateRequest.getContactName());
        corporateToUpdate.setContactTitle(updateCorporateRequest.getContactTitle());
        corporateToUpdate.setCustomer(updateCorporateRequest.getCustomerId());
        corporateRepository.save(corporateToUpdate);
    }

    @Override
    public GetCorporateResponse getById(int id) {
        Corporate corporateToId = corporateRepository.findById(id).orElseThrow();
        GetCorporateResponse getCorporateResponse = new GetCorporateResponse();
        getCorporateResponse.setCompanyName(corporateToId.getCompanyName());
        getCorporateResponse.setContactName(corporateToId.getContactName());
        getCorporateResponse.setContactTitle(corporateToId.getContactTitle());
        getCorporateResponse.setCustomerId(corporateToId.getCustomer());
        return getCorporateResponse;
    }

    @Override
    public List<GetAllCorporatesResponse> getAll() {
        List<Corporate> corporateList = corporateRepository.findAll();
        List<GetAllCorporatesResponse> getAllCorporatesResponseList = new ArrayList<>();
        for (Corporate corporate : corporateList) {
            GetAllCorporatesResponse getAllCorporatesResponse = new GetAllCorporatesResponse();
            getAllCorporatesResponse.setId(corporate.getId());
            getAllCorporatesResponse.setCompanyName(corporate.getCompanyName());
            getAllCorporatesResponse.setContactName(corporate.getContactName());
            getAllCorporatesResponse.setContactTitle(corporate.getContactTitle());
            getAllCorporatesResponse.setCustomerId(corporate.getCustomer());
            getAllCorporatesResponseList.add(getAllCorporatesResponse);
        }
        return getAllCorporatesResponseList;
    }

    @Override
    public List<Corporate> getByCompanyName(String companyName) {
        return corporateRepository.findByCompanyName(companyName);
    }

    @Override
    public List<GetListCorporateResponse> getByContactTitleILike() {
        return corporateRepository.findByContactTitleILike();
    }

    @Override
    public List<GetListCorporateResponse> getByCompanyNameAndContactTitle() {
        return corporateRepository.findByCompanyNameAndContactTitle();
    }

    @Override
    public List<GetListCorporateResponse> getOrderByContactName() {
        return corporateRepository.findOrderByContactName();
    }
}