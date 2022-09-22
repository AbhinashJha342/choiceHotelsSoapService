package com.soap.choicehotels.ChoiceHotelsSoapService.endpoints;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelRequest;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsRequest;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ChoiceHotelsEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8088/hotels";

    private HotelRepository hotelRepository;

    @Autowired
    public ChoiceHotelsEndpoint(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHotelRequest")
    @ResponsePayload
    public CreateHotelResponse createHotel(@RequestPayload CreateHotelRequest request){
        hotelRepository.save(new Hotel(request.getHotelId(), request.getName(), request.getRating()));
        CreateHotelResponse response = new CreateHotelResponse();
        response.setHotelId(request.getHotelId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelDetailsRequest")
    @ResponsePayload
    public GetHotelDetailsResponse createHotel(@RequestPayload GetHotelDetailsRequest request){
        GetHotelDetailsResponse response = new GetHotelDetailsResponse();

        return response;
    }
}
