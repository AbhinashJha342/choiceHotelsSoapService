
package com.soap.choicehotels.ChoiceHotelsSoapService.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for hotelsByNameResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hotelsByNameResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hotelId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address" type="{http://localhost:8088/hotels}addressDto"/&gt;
 *         &lt;element name="amenities" type="{http://localhost:8088/hotels}amenitiesList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelsByNameResponse", namespace = "http://localhost:8088/hotels", propOrder = {
    "hotelId",
    "name",
    "rating",
    "address",
    "amenities"
})
public class HotelsByNameResponse {

    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String hotelId;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String name;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String rating;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected AddressDto address;
    @XmlList
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected List<String> amenities;

    /**
     * Gets the value of the hotelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Sets the value of the hotelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelId(String value) {
        this.hotelId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressDto }
     *     
     */
    public AddressDto getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressDto }
     *     
     */
    public void setAddress(AddressDto value) {
        this.address = value;
    }

    /**
     * Gets the value of the amenities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the amenities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmenities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAmenities() {
        if (amenities == null) {
            amenities = new ArrayList<String>();
        }
        return this.amenities;
    }

}
