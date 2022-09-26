package com.soap.choicehotels.ChoiceHotelsSoapService.endpoints;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.validation.Valid;
import java.util.UUID;

@Endpoint
public class ChoiceHotelsEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8088/hotels";

    private HotelService hotelService;

    //TODO check for @Autowire
    @Autowired
    public ChoiceHotelsEndpoint(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHotelRequest")
    @ResponsePayload
    public CreateHotelResponse createHotel(@Valid @RequestPayload CreateHotelRequest request){
        UUID hotelId = UUID.randomUUID();
        return hotelService.createHotel(request, hotelId);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelDetailsRequest")
    @ResponsePayload
    public GetHotelDetailsResponse createHotel(@RequestPayload GetHotelDetailsRequest request){
        return hotelService.getHotelDetails(request.getHotelId());
    }
}
