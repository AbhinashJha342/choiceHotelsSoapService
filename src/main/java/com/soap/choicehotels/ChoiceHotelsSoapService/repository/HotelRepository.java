package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Optional<Hotel> getHotelByHotelId(String hotelId);

}
