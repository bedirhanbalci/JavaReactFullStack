package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Option;
import com.tobeto.rent.a.car.demo.repositories.OptionRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.OptionService;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.AddOptionRequest;
import com.tobeto.rent.a.car.demo.services.dtos.option.requests.UpdateOptionRequest;
import org.springframework.stereotype.Service;

@Service
public class OptionManager implements OptionService {

    private final OptionRepository optionRepository;

    public OptionManager(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public void add(AddOptionRequest addOptionRequest) {
        Option option = new Option();
        option.setRentalCancellationPrice(addOptionRequest.getRentalCancellationPrice());
        option.setAdditionalDriverPrice(addOptionRequest.getAdditionalDriverPrice());
        option.setRoadsideAssistancePrice(addOptionRequest.getRoadsideAssistancePrice());
        optionRepository.save(option);
    }

    @Override
    public void delete(int id) {
        Option optionToDelete = optionRepository.findById(id).orElseThrow();
        optionRepository.delete(optionToDelete);
    }

    @Override
    public void update(UpdateOptionRequest updateOptionRequest) {
        Option optionToUpdate = optionRepository.findById(updateOptionRequest.getId()).orElseThrow();
        optionToUpdate.setRentalCancellationPrice(updateOptionRequest.getRentalCancellationPrice());
        optionToUpdate.setAdditionalDriverPrice(updateOptionRequest.getAdditionalDriverPrice());
        optionToUpdate.setRoadsideAssistancePrice(updateOptionRequest.getRoadsideAssistancePrice());
        optionRepository.save(optionToUpdate);
    }
}