package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Amenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.UpdateHotelAmenitiesResponse;

public class UpdatedAmenitiesResponseMapperImpl implements Mapper<Amenities, UpdateHotelAmenitiesResponse> {


    @Override
    public UpdateHotelAmenitiesResponse map(Amenities source) {
        UpdateHotelAmenitiesResponse updateHotelAmenitiesResponse = new UpdateHotelAmenitiesResponse();
        updateHotelAmenitiesResponse.setHotelId(source.getHotelId());
        updateHotelAmenitiesResponse.getAmenities().addAll(source.getAmenities());
        return updateHotelAmenitiesResponse;
    }
}
