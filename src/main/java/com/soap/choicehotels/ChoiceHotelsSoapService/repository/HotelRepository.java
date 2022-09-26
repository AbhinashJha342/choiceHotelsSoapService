package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel getHotelByHotelId(String hotelId);

}
