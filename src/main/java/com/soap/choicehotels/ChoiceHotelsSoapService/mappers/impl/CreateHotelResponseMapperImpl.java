package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.CreateHotelResponse;

public class CreateHotelResponseMapperImpl implements Mapper<Hotel, CreateHotelResponse> {
    @Override
    public CreateHotelResponse map(Hotel source) {
        CreateHotelResponse hotelResponse = new CreateHotelResponse();
        hotelResponse.setHotelId(source.getHotelId());
        hotelResponse.setName(source.getName());
        hotelResponse.setRating(source.getRating());
        hotelResponse.setAddress(new AddressDtoMapperImpl().map(source.getAddress()));
        return hotelResponse;
    }
}
