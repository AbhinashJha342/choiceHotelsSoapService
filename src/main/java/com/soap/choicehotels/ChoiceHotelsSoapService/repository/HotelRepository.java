package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.HotelDetailsWithAmenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


    Optional<Hotel> getHotelByHotelId(String hotelId);

    @Query(nativeQuery = true, name = "hotelDetailsWithAmenities")
    HotelDetailsWithAmenities getHotelDetailsWithAmenities(String hotelId);
}
