package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Price;
import com.tobeto.rent.a.car.demo.repositories.PriceRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.PriceService;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.AddPriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.requests.UpdatePriceRequest;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetAllPricesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetListPriceResponse;
import com.tobeto.rent.a.car.demo.services.dtos.price.responses.GetPriceResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceManager implements PriceService {
    private final PriceRepository priceRepository;

    public PriceManager(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void add(AddPriceRequest addPriceRequest) {
        Price price = new Price();
        price.setOption(addPriceRequest.getOptionId());
        price.setPayment(addPriceRequest.getPaymentId());
        priceRepository.save(price);
    }

    @Override
    public void delete(int id) {
        Price priceToDelete = priceRepository.findById(id).orElseThrow();
        priceRepository.delete(priceToDelete);
    }

    @Override
    public void update(UpdatePriceRequest updatePriceRequest) {
        Price priceToUpdate = priceRepository.findById(updatePriceRequest.getId()).orElseThrow();
        priceToUpdate.setOption(updatePriceRequest.getOptionId());
        priceToUpdate.setPayment(updatePriceRequest.getPaymentId());
        priceRepository.save(priceToUpdate);
    }

    @Override
    public GetPriceResponse getById(int id) {
        Price priceToId = priceRepository.findById(id).orElseThrow();
        GetPriceResponse getPriceResponse = new GetPriceResponse();
        getPriceResponse.setOptionId(priceToId.getOption());
        getPriceResponse.setPaymentId(priceToId.getPayment());
        return getPriceResponse;
    }

    @Override
    public List<GetAllPricesResponse> getAll() {
        List<Price> priceList = priceRepository.findAll();
        List<GetAllPricesResponse> getAllPricesResponseList = new ArrayList<>();
        for (Price price : priceList) {
            GetAllPricesResponse getAllPricesResponse = new GetAllPricesResponse();
            getAllPricesResponse.setId(price.getId());
            getAllPricesResponse.setOptionId(price.getOption());
            getAllPricesResponse.setPaymentId(price.getPayment());
            getAllPricesResponseList.add(getAllPricesResponse);
        }
        return getAllPricesResponseList;
    }

    @Override
    public List<Price> getByOrderByOptionId() {
        return priceRepository.findByOrderByOptionId();
    }

    @Override
    public List<GetListPriceResponse> getByOrderByPaymentId() {
        return priceRepository.findByOrderByPaymentId();
    }
}