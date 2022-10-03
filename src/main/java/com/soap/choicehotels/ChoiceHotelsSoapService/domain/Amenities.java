package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import com.soap.choicehotels.ChoiceHotelsSoapService.configuration.StringListConverter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelId;

    @Convert(converter = StringListConverter.class)
    private List<String> amenities;


    public Amenities(Long id, String hotelId, List<String> amenities) {
        this.id = id;
        this.hotelId = hotelId;
        this.amenities = amenities;
    }

    public Amenities(String hotelId, List<String> amenities) {
        this.hotelId = hotelId;
        this.amenities = amenities;
    }

    protected Amenities() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
