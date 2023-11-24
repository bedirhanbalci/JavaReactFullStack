package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Date;
import com.tobeto.rent.a.car.demo.repositories.DateRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.DateService;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.AddDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.requests.UpdateDateRequest;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetAllDatesResponse;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetDateResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DateManager implements DateService {

    private final DateRepository dateRepository;

    public DateManager(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    @Override
    public void add(AddDateRequest addDateRequest) {
        Date date = new Date();
        date.setStartDate(addDateRequest.getStartDate());
        date.setEndDate(addDateRequest.getEndDate());
        date.setExtendDate(addDateRequest.getExtendDate());
        dateRepository.save(date);
    }

    @Override
    public void delete(int id) {
        Date dateToDelete = dateRepository.findById(id).orElseThrow();
        dateRepository.delete(dateToDelete);
    }

    @Override
    public void update(UpdateDateRequest updateDateRequest) {
        Date dateToUpdate = dateRepository.findById(updateDateRequest.getId()).orElseThrow();
        dateToUpdate.setStartDate(updateDateRequest.getStartDate());
        dateToUpdate.setEndDate(updateDateRequest.getEndDate());
        dateToUpdate.setExtendDate(updateDateRequest.getExtendDate());
        dateRepository.save(dateToUpdate);
    }

    @Override
    public GetDateResponse getById(int id) {
        Date dateToId = dateRepository.findById(id).orElseThrow();
        GetDateResponse getDateResponse = new GetDateResponse();
        getDateResponse.setStartDate(dateToId.getStartDate());
        getDateResponse.setEndDate(dateToId.getEndDate());
        getDateResponse.setExtendDate(dateToId.getExtendDate());
        return getDateResponse;
    }

    @Override
    public List<GetAllDatesResponse> getAll() {
        List<Date> dateList = dateRepository.findAll();
        List<GetAllDatesResponse> getAllDatesResponseList = new ArrayList<>();
        for (Date date : dateList) {
            GetAllDatesResponse getAllDatesResponse = new GetAllDatesResponse();
            getAllDatesResponse.setId(date.getId());
            getAllDatesResponse.setStartDate(date.getStartDate());
            getAllDatesResponse.setEndDate(date.getEndDate());
            getAllDatesResponse.setExtendDate(date.getExtendDate());
            getAllDatesResponseList.add(getAllDatesResponse);
        }
        return getAllDatesResponseList;
    }
}