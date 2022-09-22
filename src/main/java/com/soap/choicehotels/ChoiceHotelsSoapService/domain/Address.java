package com.soap.choicehotels.ChoiceHotelsSoapService.domain;




import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    private String state;

    private String postalCode;

    @Embedded
    private AddressLines addressLines;

    @OneToOne
    @JoinColumn(name="hotelId")
    private Hotel hotel;

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

    public Address() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static com.soap.choicehotels.ChoiceHotelsSoapService.model.Address from(Address address){
        com.soap.choicehotels.ChoiceHotelsSoapService.model.Address addressModel =  new com.soap.choicehotels.ChoiceHotelsSoapService.model.Address();
        addressModel.setCity(address.getCity());
        addressModel.setState(address.getState());
        addressModel.setPostalCode(address.getPostalCode());
        addressModel.setAddressLines(AddressLines.from(address.getAddressLines()));
        return addressModel;
    }
}
