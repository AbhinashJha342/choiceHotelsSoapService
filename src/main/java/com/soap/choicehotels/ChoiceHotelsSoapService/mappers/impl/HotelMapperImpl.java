package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.CreateHotelRequest;

public class HotelMapperImpl implements Mapper<CreateHotelRequest, Hotel> {

    @Override
    public Hotel map(CreateHotelRequest source) {
        Address address = new AddressMapperImpl().map(source.getAddress());
        Hotel hotel = new Hotel(null, source.getName(), source.getRating(), address, false);
        return hotel;
    }
}
