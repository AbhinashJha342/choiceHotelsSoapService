package com.soap.choicehotels.ChoiceHotelsSoapService.domain;


import javax.persistence.Embeddable;

@Embeddable
public class AddressLines {

    private String exterior;

    private String street;

    public AddressLines(String exterior, String street) {
        this.exterior = exterior;
        this.street = street;
    }

    public AddressLines() {
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

    public static com.soap.choicehotels.ChoiceHotelsSoapService.model.AddressLines from(AddressLines addressLines){
        com.soap.choicehotels.ChoiceHotelsSoapService.model.AddressLines addressLinesModel = new com.soap.choicehotels.ChoiceHotelsSoapService.model.AddressLines();
        addressLinesModel.setExterior(addressLines.getExterior());
        addressLinesModel.setStreet(addressLines.getStreet());
        return addressLinesModel;
    }
}
