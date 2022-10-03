package com.soap.choicehotels.ChoiceHotelsSoapService.service.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.CustomDbDataUpdatedException;
import com.soap.choicehotels.ChoiceHotelsSoapService.exception.NotFoundException;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl.*;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.AmenitiesRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.repository.HotelRepository;
import com.soap.choicehotels.ChoiceHotelsSoapService.service.HotelService;
import org.choicehotel.generated.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository repository;

    private final AmenitiesRepository amenitiesRepository;

    public HotelServiceImpl(HotelRepository repository, AmenitiesRepository amenitiesRepository) {
        this.repository = repository;
        this.amenitiesRepository = amenitiesRepository;
    }

    @Override
    public CreateHotelResponse createHotel(CreateHotelRequest hotelRequest, UUID hotelId) {
        Hotel hotel = new HotelMapperImpl().map(hotelRequest);
        hotel.setHotelId(hotelId.toString());
        Hotel createdHotel = repository.save(hotel);
        return new CreateHotelResponseMapperImpl().map(createdHotel);
    }

    @Override
    public GetHotelDetailsResponse getHotelDetails(String hotelId) throws NotFoundException {
        repository.getHotelByHotelIdAndDeletedIsFalse(hotelId).orElseThrow(()-> new NotFoundException("Invalid hotelId", "No hotel found for the provided hotelId. "+ hotelId));
        HotelDetailsWithAmenitiesByHotelId hotelDetailsWithAmenities = repository.getHotelDetailsWithAmenitiesByHotelId(hotelId);
        return new HotelResponseMapperImpl().map(hotelDetailsWithAmenities);
    }

    @Override
    public UpdateHotelResponse updateHotelDetails(UpdateHotelRequest updateHotelRequest) throws NotFoundException {
        Hotel hotel = repository.getHotelByHotelIdAndDeletedIsFalse(updateHotelRequest.getHotelId()).orElseThrow(()-> new NotFoundException("Invalid hotelId","No hotel found for the provided hotelId. "+updateHotelRequest.getHotelId() ));
        hotel.setAddress(new AddressMapperImpl().map(updateHotelRequest.getAddress()));
        hotel.setName(updateHotelRequest.getName());
        hotel.setRating(updateHotelRequest.getRating());
        return new UpdatedHotelResponseMapperImpl().map(repository.save(hotel));
    }

    @Override
    public CreateHotelAmenitiesResponse createHotelAmenities(CreateHotelAmenitiesRequest amenities) throws CustomDbDataUpdatedException, NotFoundException {
        Hotel hotel = repository.getHotelByHotelIdAndDeletedIsFalse(amenities.getHotelId()).orElseThrow(()-> new NotFoundException("Invalid hotelId", "No hotel found for the given hotelId. "+amenities.getHotelId()));
        Optional<Amenities> amenities1 = amenitiesRepository.findAmenitiesByHotelId(hotel.getHotelId());
        if(amenities1.isPresent())
            throw new CustomDbDataUpdatedException("Invalid data.", "amenities already exist for this hotel with hotelId " + hotel.getHotelId() + "Please use the update option.");
        Amenities amenitiesCreated = amenitiesRepository.save(new AmenitiesMapperImpl().map(amenities));
        return new HotelAmenitiesResponseMapperImpl().map(amenitiesCreated);
    }

    @Override
    public UpdateHotelAmenitiesResponse updateHotelAmenities(UpdateHotelAmenitiesRequest updatedAmenities) throws NotFoundException {
        repository.getHotelByHotelIdAndDeletedIsFalse(updatedAmenities.getHotelId()).orElseThrow(()-> new NotFoundException("Invalid hotelId", "No hotel found for this hotelId. "+updatedAmenities.getHotelId()));
        Amenities existingAmenities = amenitiesRepository.findAmenitiesByHotelId(updatedAmenities.getHotelId()).orElseThrow(()-> new NotFoundException("No amenities created for this hotel.", "No amenities created for this hotel."+updatedAmenities.getHotelId()+"Please create the amenities before updating."));
        existingAmenities.setAmenities(updatedAmenities.getAmenities());
        amenitiesRepository.save(existingAmenities);
        return new UpdatedAmenitiesResponseMapperImpl().map(existingAmenities);
    }

    @Override
    public void deleteHotel(DeleteHotelRequest deleteHotelRequest) throws NotFoundException {
        Hotel hotel = repository.getHotelByHotelIdAndDeletedIsFalse(deleteHotelRequest.getHotelId()).orElseThrow(()-> new NotFoundException("Invalid hotelId", "This hotel doesn't exist. Please check the hotelId. "+deleteHotelRequest.getHotelId()));
        hotel.setDeleted(true);
        repository.save(hotel);
        amenitiesRepository.findAmenitiesByHotelId(hotel.getHotelId()).ifPresent(amenities -> amenitiesRepository.deleteById(amenities.getId()));
    }

    @Override
    public GetHotelByNameResponse getAllHotel() throws NotFoundException {
        List<HotelDetailsWithAmenities> hotelList = repository.getHotelsByDeletedIsFalse().orElseThrow(()-> new NotFoundException("Invalid request", "No hotel exists."));
        return new AllHotelDetailsResponseMapperImpl().map(hotelList);
    }

    @Override
    public GetHotelByNameResponse getHotelDetailByName(GetHotelByNameRequest getHotelDetailsRequest) throws NotFoundException {
        List<HotelDetailsByName> hotelDetailsByNames = repository.getHotelsByNameContainingIgnoreCaseAndDeletedIsFalse(getHotelDetailsRequest.getName()).orElseThrow(()-> new NotFoundException("Invalid Input", "No hotel exists with the name or whose name consists. "+getHotelDetailsRequest.getName()));
        return new HotelsByNameMapperImpl().map(hotelDetailsByNames);
    }
}
