package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsByName;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsWithAmenities;
import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsWithAmenitiesByHotelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


    Optional<Hotel> getHotelByHotelIdAndDeletedIsFalse(String hotelId);

    @Query(nativeQuery = true, name = "amenitiesByHotelIdMapping")
    HotelDetailsWithAmenitiesByHotelId getHotelDetailsWithAmenitiesByHotelId(@Param("hotelId") String hotelId);

    @Query(nativeQuery = true, name = "hotelAmenitiesMapping")
    Optional<List<HotelDetailsWithAmenities>> getHotelsByDeletedIsFalse();

    @Query(nativeQuery = true, name = "hotelsByNameMapping")
    Optional<List<HotelDetailsByName>> getHotelsByNameContainingIgnoreCaseAndDeletedIsFalse(@Param("name") String name);
}
