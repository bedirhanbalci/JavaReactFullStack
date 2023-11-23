package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Corporate;
import com.tobeto.rent.a.car.demo.repositories.CorporateRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CorporateService;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.AddCorporateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.corporate.requests.UpdateCorporateRequest;
import org.springframework.stereotype.Service;

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
}