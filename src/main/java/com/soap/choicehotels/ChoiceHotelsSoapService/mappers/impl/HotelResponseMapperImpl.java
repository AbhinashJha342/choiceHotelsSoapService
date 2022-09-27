package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsWithAmenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

public class HotelResponseMapperImpl implements Mapper<HotelDetailsWithAmenities, GetHotelDetailsResponse> {

    @Override
    public GetHotelDetailsResponse map(HotelDetailsWithAmenities source) {
        GetHotelDetailsResponse hotelDetailsResponse = new GetHotelDetailsResponse();
        hotelDetailsResponse.setHotelId(source.getHotel_id());
        hotelDetailsResponse.setName(source.getName());
        hotelDetailsResponse.setRating(source.getRating());
        Address address = new Address(source.getCity(), source.getState(), source.getPostal_code(), new AddressLines(source.getExterior(), source.getStreet()));
        hotelDetailsResponse.setAddress(new AddressDtoMapperImpl().map(address));
        List<String> amenities  = source.getAmenities() != null ? Arrays.asList(source.getAmenities().split(";")) : emptyList();
        hotelDetailsResponse.getAmenities().addAll(amenities);
        return hotelDetailsResponse;
    }
}
