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

    private boolean deleted;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Address address;

    public Hotel(Long id, String hotelId, String name, String rating, Address address,  boolean deleted) {
        this.id = id;
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.deleted = deleted;
        this.address = address;
    }

    public Hotel(String hotelId, String name, String rating, Address address,  boolean deleted) {
        this.hotelId = hotelId;
        this.name = name;
        this.rating = rating;
        this.deleted = deleted;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return deleted == hotel.deleted && Objects.equals(id, hotel.id) && Objects.equals(hotelId, hotel.hotelId) && Objects.equals(name, hotel.name) && Objects.equals(rating, hotel.rating) && Objects.equals(address, hotel.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, name, rating, deleted, address);
    }
}
