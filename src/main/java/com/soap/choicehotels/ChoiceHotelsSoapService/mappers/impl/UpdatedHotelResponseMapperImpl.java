package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.UpdateHotelResponse;

public class UpdatedHotelResponseMapperImpl implements Mapper<Hotel, UpdateHotelResponse> {


    @Override
    public UpdateHotelResponse map(Hotel source) {
        UpdateHotelResponse updateHotelResponse = new UpdateHotelResponse();
        updateHotelResponse.setHotelId(source.getHotelId());
        updateHotelResponse.setName(source.getName());
        updateHotelResponse.setRating(source.getRating());
        updateHotelResponse.setAddress(new AddressDtoMapperImpl().map(source.getAddress()));
        return updateHotelResponse;
    }
}
