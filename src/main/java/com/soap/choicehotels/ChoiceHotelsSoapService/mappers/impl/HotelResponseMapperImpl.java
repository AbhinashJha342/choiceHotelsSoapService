package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;

public class HotelResponseMapperImpl implements Mapper<Hotel, GetHotelDetailsResponse> {


    @Override
    public GetHotelDetailsResponse map(Hotel source) {
        GetHotelDetailsResponse hotelDetailsResponse = new GetHotelDetailsResponse();
        hotelDetailsResponse.setHotelId(source.getHotelId());
        hotelDetailsResponse.setName(source.getName());
        hotelDetailsResponse.setRating(source.getRating());
        hotelDetailsResponse.setAddress(new AddressDtoMapperImpl().map(source.getAddress()));
        return hotelDetailsResponse;
    }
}
