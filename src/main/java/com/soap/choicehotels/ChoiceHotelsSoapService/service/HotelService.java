package com.soap.choicehotels.ChoiceHotelsSoapService.service;


import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;

import java.util.UUID;

public interface HotelService {

    CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId);

    GetHotelDetailsResponse getHotelDetails(String hotelId);

    CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities);

    UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updatedAmenities);

}
