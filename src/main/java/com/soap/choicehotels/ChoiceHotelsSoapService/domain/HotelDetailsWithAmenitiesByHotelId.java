package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import javax.persistence.*;

@SqlResultSetMapping(
        name="amenitiesByHotelIdMapping",
        classes={
                @ConstructorResult(
                        targetClass= HotelDetailsWithAmenitiesByHotelId.class,
                        columns={
                                @ColumnResult(name="hotel_id"),
                                @ColumnResult(name="name"),
                                @ColumnResult(name="rating"),
                                @ColumnResult(name="exterior"),
                                @ColumnResult(name="street"),
                                @ColumnResult(name="city"),
                                @ColumnResult(name="postal_code"),
                                @ColumnResult(name="state"),
                                @ColumnResult(name="amenities")
                        }
                )
        }
)
@NamedNativeQuery(name = "amenitiesByHotelIdMapping", query = "select ht.hotel_id, ht.name, ht.rating, addr.exterior, addr.street, addr.city, addr.postal_code, \n" +
        "addr.state, amen.amenities from hotel ht left outer join address addr on ht.address_id = addr.id and ht.deleted is false\n" +
        "left outer join amenities amen on ht.hotel_id = amen.hotel_id where ht.hotel_id=:hotelId", resultClass = HotelDetailsWithAmenitiesByHotelId.class,
        resultSetMapping = "amenitiesByHotelIdMapping")

@Entity
public class HotelDetailsWithAmenitiesByHotelId {

    private String hotel_id;

    private String name;

    private String rating;

    private String exterior;

    private String street;

    private String city;

    private String postal_code;

    private String state;

    private String amenities;

    @Id
    private Long id;

    public HotelDetailsWithAmenitiesByHotelId(String hotel_id, String name, String rating, String exterior, String street, String city, String postal_code, String state, String amenities) {
        this.hotel_id = hotel_id;
        this.name = name;
        this.rating = rating;
        this.exterior = exterior;
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.state = state;
        this.amenities = amenities;
    }

    public HotelDetailsWithAmenitiesByHotelId() {
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
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

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getExterior() {
        return exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
