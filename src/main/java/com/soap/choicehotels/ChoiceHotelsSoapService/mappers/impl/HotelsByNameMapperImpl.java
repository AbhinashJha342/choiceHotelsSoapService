package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsByName;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.GetHotelByNameResponse;
import org.choicehotel.generated.HotelsByNameResponse;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

public class HotelsByNameMapperImpl implements Mapper<List<HotelDetailsByName>, GetHotelByNameResponse> {


    @Override
    public GetHotelByNameResponse map(List<HotelDetailsByName> source) {
        GetHotelByNameResponse hotelDetailsResponse = new GetHotelByNameResponse();
        for (HotelDetailsByName hotels : source) {
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
