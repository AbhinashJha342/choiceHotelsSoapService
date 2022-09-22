package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import com.soap.choicehotels.ChoiceHotelsSoapService.model.GetHotelDetailsResponse;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelId;

    private String name;

    private String rating;

    private boolean isDeleted;

    @OneToOne(cascade = {CascadeType.PERSIST}, mappedBy = "hotel", orphanRemoval = true)
    private Address address;

    public Hotel(Long id, String hotelId, String name, String rating, Address address,  boolean isDeleted) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.isDeleted = isDeleted;
    }

    public Hotel(String hotelId, String name, String rating, Address address,  boolean isDeleted) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.isDeleted = isDeleted;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public Address getAddress() {
        return address;
    }

    public static GetHotelDetailsResponse from (Hotel hotel){
        GetHotelDetailsResponse response = new GetHotelDetailsResponse();
        response.setHotelId(hotel.getHotelId());
        response.setName(hotel.getName());
        response.setRating(hotel.getRating());
        response.setAddress(Address.from(hotel.getAddress()));
        return response;
    }
}
