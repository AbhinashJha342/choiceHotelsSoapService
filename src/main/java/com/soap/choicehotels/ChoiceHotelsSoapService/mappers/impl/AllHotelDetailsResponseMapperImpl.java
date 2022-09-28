package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsWithAmenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelByNameResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.HotelsByNameResponse;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

public class AllHotelDetailsResponseMapperImpl implements Mapper<List<HotelDetailsWithAmenities>, GetHotelByNameResponse> {

    @Override
    public GetHotelByNameResponse map(List<HotelDetailsWithAmenities> source) {
        GetHotelByNameResponse hotelDetailsResponse = new GetHotelByNameResponse();
        for (HotelDetailsWithAmenities hotels : source) {
            HotelsByNameResponse hotelsByNameResponse = new HotelsByNameResponse();
            hotelsByNameResponse.setHotelId(hotels.getHotel_id());
            hotelsByNameResponse.setName(hotels.getName());
            hotelsByNameResponse.setRating(hotels.getRating());
            Address address = new Address(hotels.getCity(), hotels.getState(), hotels.getPostal_code(), new AddressLines(hotels.getExterior(), hotels.getStreet()));
            hotelsByNameResponse.setAddress(new AddressDtoMapperImpl().map(address));
            List<String> amenities  = hotels.getAmenities() != null ? Arrays.asList(hotels.getAmenities().split(";")) : emptyList();
            hotelsByNameResponse.getAmenities().addAll(amenities);
            hotelDetailsResponse.getHotelDetails().add(hotelsByNameResponse);
        }
        return hotelDetailsResponse;
    }
}
