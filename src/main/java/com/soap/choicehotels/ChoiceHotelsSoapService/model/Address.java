
package com.soap.choicehotels.ChoiceHotelsSoapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="addressLines" type="{http://localhost:8088/hotels}addressLines"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", namespace = "http://localhost:8088/hotels", propOrder = {
    "city",
    "state",
    "postalCode",
    "addressLines"
})
public class Address {

    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String city;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String state;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String postalCode;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected AddressLines addressLines;

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the addressLines property.
     * 
     * @return
     *     possible object is
     *     {@link AddressLines }
     *     
     */
    public AddressLines getAddressLines() {
        return addressLines;
    }

    /**
     * Sets the value of the addressLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressLines }
     *     
     */
    public void setAddressLines(AddressLines value) {
        this.addressLines = value;
    }

    public static com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address to(Address address){
        if(address == null)
            return null;

        return new com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address(
                address.getCity(), address.getState(), address.postalCode, AddressLines.to(address.getAddressLines())
        );
    }

}
