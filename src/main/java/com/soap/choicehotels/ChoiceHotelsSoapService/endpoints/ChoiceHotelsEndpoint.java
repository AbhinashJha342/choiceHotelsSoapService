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

    //TODO check for @Autowire
    @Autowired
    public ChoiceHotelsEndpoint(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHotelRequest")
    @ResponsePayload
    public CreateHotelResponse createHotel(@RequestPayload CreateHotelRequest request){
        UUID hotelId = UUID.randomUUID();
        Hotel hotel = hotelRepository.save(new Hotel(hotelId.toString(), request.getName(), request.getRating(), Address.to(request.getAddress()), false));
        CreateHotelResponse response = new CreateHotelResponse();
        response.setHotelId(hotel.getHotelId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelDetailsRequest")
    @ResponsePayload
    public GetHotelDetailsResponse createHotel(@RequestPayload GetHotelDetailsRequest request){
        GetHotelDetailsResponse response = new GetHotelDetailsResponse();
        return Hotel.from(hotelRepository.getHotelByHotelId(request.getHotelId()));
    }
}
