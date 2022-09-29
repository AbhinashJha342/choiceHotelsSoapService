package com.soap.choicehotels.ChoiceHotelsSoapService.service;


import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId);

    GetHotelDetailsResponse getHotelDetails(String hotelId);

    UpdateHotelResponse updateHotelDetails(UpdateHotelRequest updateHotelRequest);

    CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities);

    UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updatedAmenities);

    void deleteHotel(DeleteHotelRequest deleteHotelRequest);

    GetHotelByNameResponse getAllHotel();

    GetHotelByNameResponse getHotelDetailByName(GetHotelByNameRequest getHotelDetailsRequest);



}
