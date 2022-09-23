package com.soap.choicehotels.ChoiceHotelsSoapService.repository;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Hotel;
import org.springframework.data.repository.CrudRepository;


//change to JpaRepository
public interface HotelRepository extends CrudRepository<Hotel, Long> {

    Hotel getHotelByHotelId(String hotelId);

}
