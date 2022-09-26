package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelId;

    private String name;

    private String rating;

    private boolean isDeleted;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    //@JoinColumn(name = "address_id")
    private Address address;

    public Hotel(Long id, String hotelId, String name, String rating, Address address,  boolean isDeleted) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.isDeleted = isDeleted;
        this.address = address;
    }

    public Hotel(String hotelId, String name, String rating, Address address,  boolean isDeleted) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.isDeleted = isDeleted;
        this.address = address;
    }

    protected Hotel() {
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

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return isDeleted == hotel.isDeleted && Objects.equals(id, hotel.id) && Objects.equals(hotelId, hotel.hotelId) && Objects.equals(name, hotel.name) && Objects.equals(rating, hotel.rating) && Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, name, rating, isDeleted, address);
    }

    //generate equals and hashcode
}
