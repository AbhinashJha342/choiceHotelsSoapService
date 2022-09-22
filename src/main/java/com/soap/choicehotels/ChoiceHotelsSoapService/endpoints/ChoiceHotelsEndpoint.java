package com.soap.choicehotels.ChoiceHotelsSoapService.endpoints;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.UUID;

@Endpoint
public class ChoiceHotelsEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8088/hotels";

    private HotelRepository hotelRepository;

    @Autowired
    public ChoiceHotelsEndpoint(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHotelRequestDto")
    @ResponsePayload
    public CreateHotelResponseDto createHotel(@RequestPayload CreateHotelRequestDto request){
        UUID hotelId = UUID.randomUUID();
        Hotel hotel = hotelRepository.save(new Hotel(hotelId.toString(), request.getName(), request.getRating(), false));
        CreateHotelResponseDto response = new CreateHotelResponseDto();
        response.setHotelId(hotel.getHotelId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelDetailsRequestDto")
    @ResponsePayload
    public GetHotelDetailsResponseDto createHotel(@RequestPayload GetHotelDetailsRequestDto request){
        GetHotelDetailsResponseDto response = new GetHotelDetailsResponseDto();
        Hotel hotel = hotelRepository.getHotelByHotelId(request.getHotelId());
        return response;
    }
}
