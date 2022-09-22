package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelId;

    private String name;

    private String rating;


    public Hotel(Long id, String hotelId, String name, String rating) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
    }

    public Hotel(String hotelId, String name, String rating) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
    }

    public Hotel() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
