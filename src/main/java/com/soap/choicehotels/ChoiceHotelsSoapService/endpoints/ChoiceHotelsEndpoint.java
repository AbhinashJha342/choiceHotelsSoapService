package com.soap.choicehotels.ChoiceHotelsSoapService.endpoints;

import com.soap.choicehotels.ChoiceHotelsSoapService.exception.CustomDbDataUpdatedException;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.NotFoundException;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.choicehotel.generated.*;
import org.springframework.util.ObjectUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.validation.Valid;
import java.util.UUID;

@Endpoint
public class ChoiceHotelsEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8088/hotels";

    private final HotelService hotelService;

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
    public GetHotelDetailsResponse getHotelDetails(@RequestPayload GetHotelDetailsRequest request) throws NotFoundException {
        return hotelService.getHotelDetails(request.getHotelId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateHotelRequest")
    @ResponsePayload
    public UpdateHotelResponse updateHotelDetails(@RequestPayload UpdateHotelRequest request) throws NotFoundException {
        return hotelService.updateHotelDetails(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createHotelAmenitiesRequest")
    @ResponsePayload
    public CreateHotelAmenitiesResponse createHotelAmenities(@RequestPayload CreateHotelAmenitiesRequest amenities) throws CustomDbDataUpdatedException, NotFoundException {
        return hotelService.createHotelAmenities(amenities);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateHotelAmenitiesRequest")
    @ResponsePayload
    public UpdateHotelAmenitiesResponse updateHotelAmenities(@RequestPayload UpdateHotelAmenitiesRequest updatedAmenities) throws NotFoundException {
        return hotelService.updateHotelAmenities(updatedAmenities);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteHotelRequest")
    @ResponsePayload
    public DeleteHotelResponse deleteHotel(@RequestPayload DeleteHotelRequest deleteHotelRequest) throws NotFoundException {
        hotelService.deleteHotel(deleteHotelRequest);
        DeleteHotelResponse deleteHotelResponse = new DeleteHotelResponse();
        deleteHotelResponse.setHotelId(deleteHotelRequest.getHotelId());
        return deleteHotelResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHotelByNameRequest")
    @ResponsePayload
    public GetHotelByNameResponse getHotelDetailsByName(@RequestPayload GetHotelByNameRequest getHotelByNameRequest) throws NotFoundException {

        if(ObjectUtils.isEmpty(getHotelByNameRequest) || ObjectUtils.isEmpty(getHotelByNameRequest.getName()))
            return hotelService.getAllHotel();

        return hotelService.getHotelDetailByName(getHotelByNameRequest);
    }

}
