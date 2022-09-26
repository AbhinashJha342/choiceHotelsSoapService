package com.soap.choicehotels.ChoiceHotelsSoapService.service.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl.CreateHotelResponseMapperImpl;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl.HotelMapperImpl;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelRequest;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository repository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId) {
        Hotel hotel = new HotelMapperImpl().map(hotelRequest);
        hotel.setHotelId(hotelId.toString());
        Hotel createdHotel = repository.save(hotel);
        return new CreateHotelResponseMapperImpl().map(createdHotel);
    }
}
