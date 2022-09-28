package com.soap.choicehotels.ChoiceHotelsSoapService.service.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.NotFoundException;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.AmenitiesRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    private final AmenitiesRepository amenitiesRepository;

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
        repository.getHotelByHotelIdAndDeletedIsFalse(hotelId).orElseThrow(()-> new NotFoundException("No hotel found by this criteria."));
        HotelDetailsWithAmenitiesByHotelId hotelDetailsWithAmenities = repository.getHotelDetailsWithAmenitiesByHotelId(hotelId);
        return new HotelResponseMapperImpl().map(hotelDetailsWithAmenities);
    }

    @Override
    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities) {
        repository.getHotelByHotelIdAndDeletedIsFalse(amenities.getHotelId()).orElseThrow(()-> new NotFoundException("No hotel found by this criteria."));
        Amenities amenitiesCreated = amenitiesRepository.save(new AmenitiesMapperImpl().map(amenities));
        return new HotelAmenitiesResponseMapperImpl().map(amenitiesCreated);
    }

    @Override
    public UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updatedAmenities) {
        repository.getHotelByHotelIdAndDeletedIsFalse(updatedAmenities.getHotelId()).orElseThrow(()-> new NotFoundException("No hotel found for the hotelId."));
        Amenities existingAmenities = amenitiesRepository.findAmenitiesByHotelId(updatedAmenities.getHotelId()).orElseThrow(()-> new NotFoundException("No amenities exists for update for the provided hotelId."+updatedAmenities.getHotelId()));
        existingAmenities.setAmenities(updatedAmenities.getAmenities());
        amenitiesRepository.save(existingAmenities);
        return new UpdatedAmenitiesResponseMapperImpl().map(existingAmenities);
    }

    @Override
    public void deleteHotel(DeleteHotelRequest deleteHotelRequest) {
        Hotel hotel = repository.getHotelByHotelIdAndDeletedIsFalse(deleteHotelRequest.getHotelId()).orElseThrow(()-> new NotFoundException("No hotel found by this criteria."));
        hotel.setDeleted(true);
        repository.save(hotel);
    }

    @Override
    public GetHotelByNameResponse getAllHotel() {
        List<HotelDetailsWithAmenities> hotelList = repository.getHotelsByDeletedIsFalse().orElseThrow(()-> new NotFoundException("No hotel are registered."));
        return new AllHotelDetailsResponseMapperImpl().map(hotelList);
    }

    @Override
    public GetHotelByNameResponse getHotelDetailByName(GetHotelByNameRequest getHotelDetailsRequest) {
        List<HotelDetailsByName> hotelDetailsByNames = repository.getHotelsByNameContainingIgnoreCaseAndDeletedIsFalse(getHotelDetailsRequest.getName()).orElseThrow(()-> new NotFoundException("No hotel found with the given criteria."));
        return new HotelsByNameMapperImpl().map(hotelDetailsByNames);
    }
}
