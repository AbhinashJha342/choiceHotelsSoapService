package com.soap.choicehotels.ChoiceHotelsSoapService.service.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Amenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.NotFoundException;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.AmenitiesRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository repository;

    private AmenitiesRepository amenitiesRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository, AmenitiesRepository amenitiesRepository) {
        this.repository = repository;
        this.amenitiesRepository = amenitiesRepository;
    }

    @Override
    public CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId) {
        Hotel hotel = new HotelMapperImpl().map(hotelRequest);
        hotel.setHotelId(hotelId.toString());
        Hotel createdHotel = repository.save(hotel);
        return new CreateHotelResponseMapperImpl().map(createdHotel);
    }

    @Override
    public GetHotelDetailsResponse getHotelDetails(String hotelId) {
        Hotel hotel = repository.getHotelByHotelId(hotelId).orElseThrow(()-> new NotFoundException("No hotel found by this criteria."));
        return new HotelResponseMapperImpl().map(hotel);
    }

    @Override
    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities) {
        repository.getHotelByHotelId(amenities.getHotelId()).orElseThrow(()-> new NotFoundException("No hotel found by this criteria."));
        Amenities amenitiesCreated = amenitiesRepository.save(new AmenitiesMapperImpl().map(amenities));
        return new HotelAmenitiesResponseMapperImpl().map(amenitiesCreated);
    }
}
