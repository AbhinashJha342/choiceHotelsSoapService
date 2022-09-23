
package com.soap.choicehotels.ChoiceHotelsSoapService.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressLines complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressLines"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="exterior" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressLines", namespace = "http://localhost:8088/hotels", propOrder = {
    "exterior",
    "street"
})
public class AddressLines {

    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String exterior;
    @XmlElement(namespace = "http://localhost:8088/hotels", required = true)
    protected String street;

    /**
     * Gets the value of the exterior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExterior() {
        return exterior;
    }

    /**
     * Sets the value of the exterior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExterior(String value) {
        this.exterior = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    public static com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines to(AddressLines addressLines){
        if(addressLines == null)
            return null;

        return new com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines(addressLines.getExterior(), addressLines.getStreet());
    }

}
