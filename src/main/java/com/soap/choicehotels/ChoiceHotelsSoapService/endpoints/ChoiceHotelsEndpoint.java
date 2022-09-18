package com.soap.choicehotels.ChoiceHotelsSoapService.endpoints;

import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelRequest;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.CreateHotelResponse;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/hotels")
public class ChoiceHotelsEndpoint {

    private HotelRepository hotelRepository;

    @Autowired
    public ChoiceHotelsEndpoint(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @ResponsePayload
    public CreateHotelResponse createHotel(@RequestPayload CreateHotelRequest request){
        hotelRepository.save(request);

        return null;
    }
}
