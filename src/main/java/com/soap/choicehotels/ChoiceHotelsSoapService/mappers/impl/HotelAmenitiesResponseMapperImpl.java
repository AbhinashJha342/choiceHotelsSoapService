package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Amenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelAmenitiesResponse;

public class HotelAmenitiesResponseMapperImpl implements Mapper<Amenities, CreateHotelAmenitiesResponse> {

    @Override
    public CreateHotelAmenitiesResponse map(Amenities source) {
        CreateHotelAmenitiesResponse createHotelAmenitiesResponse = new CreateHotelAmenitiesResponse();
        createHotelAmenitiesResponse.setHotelId(source.getHotelId());
        createHotelAmenitiesResponse.getAmenities().addAll(source.getAmenities());
        return createHotelAmenitiesResponse;
    }
}
