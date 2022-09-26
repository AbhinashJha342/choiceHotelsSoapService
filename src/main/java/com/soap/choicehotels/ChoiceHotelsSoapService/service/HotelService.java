package com.soap.choicehotels.ChoiceHotelsSoapService.service;


import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelRequest;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;

import java.util.UUID;

public interface HotelService {

    CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId);

    GetHotelDetailsResponse getHotelDetails(String hotelId);

}
