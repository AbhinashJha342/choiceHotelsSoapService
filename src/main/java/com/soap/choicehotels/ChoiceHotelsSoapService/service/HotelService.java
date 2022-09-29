package com.soap.choicehotels.ChoiceHotelsSoapService.service;


import com.soap.choicehotels.ChoiceHotelsSoapService.exception.CustomDbDataUpdatedException;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.NotFoundException;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId);

    GetHotelDetailsResponse getHotelDetails(String hotelId) throws NotFoundException;

    UpdateHotelResponse updateHotelDetails(UpdateHotelRequest updateHotelRequest) throws NotFoundException;

    CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities) throws CustomDbDataUpdatedException, NotFoundException;

    UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updatedAmenities) throws NotFoundException;

    void deleteHotel(DeleteHotelRequest deleteHotelRequest) throws NotFoundException;

    GetHotelByNameResponse getAllHotel() throws NotFoundException;

    GetHotelByNameResponse getHotelDetailByName(GetHotelByNameRequest getHotelDetailsRequest) throws NotFoundException;



}
