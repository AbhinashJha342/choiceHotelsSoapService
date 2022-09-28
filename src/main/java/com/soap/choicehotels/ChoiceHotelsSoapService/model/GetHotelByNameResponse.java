
package com.soap.choicehotels.ChoiceHotelsSoapService.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hotelDetails" type="{http://localhost:8088/hotels}hotelsByNameResponse" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hotelDetails"
})
@XmlRootElement(name = "getHotelByNameResponse", namespace = "http://localhost:8088/hotels")
public class GetHotelByNameResponse {

    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected List<HotelsByNameResponse> hotelDetails;

    /**
     * Gets the value of the hotelDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the hotelDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelsByNameResponse }
     * 
     * 
     */
    public List<HotelsByNameResponse> getHotelDetails() {
        if (hotelDetails == null) {
            hotelDetails = new ArrayList<HotelsByNameResponse>();
        }
        return this.hotelDetails;
    }

}
