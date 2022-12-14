package com.soap.choicehotels.ChoiceHotelsSoapService.domain;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String state;

    private String postalCode;

    @Embedded
    private AddressLines addressLines;

    public Address(Long id, String city, String state, String postalCode, AddressLines addressLines) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.addressLines = addressLines;
    }

    public Address(String city, String state, String postalCode, AddressLines addressLines) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.addressLines = addressLines;
    }

    protected Address() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public AddressLines getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(AddressLines addressLines) {
        this.addressLines = addressLines;
    }

}
