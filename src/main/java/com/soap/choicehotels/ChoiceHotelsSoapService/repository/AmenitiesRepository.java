package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {

    Optional<Amenities> findAmenitiesByHotelId(String hotelId);
}
