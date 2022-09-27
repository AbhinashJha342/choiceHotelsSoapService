package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Amenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelAmenitiesRequest;

public class AmenitiesMapperImpl implements Mapper<CreateHotelAmenitiesRequest, Amenities> {


    @Override
    public Amenities map(CreateHotelAmenitiesRequest source) {
       return new Amenities(source.getHotelId(), source.getAmenities());
    }
}
