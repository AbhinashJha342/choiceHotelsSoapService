package com.soap.choicehotels.ChoiceHotelsSoapService.domain;




import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    protected String state;

    protected String postalCode;

    @Embedded
    protected AddressLines addressLines;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
