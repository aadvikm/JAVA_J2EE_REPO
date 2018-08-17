
package com.apache.webservice.tutorial.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for locationOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="locationOutputData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countryList" type="{http://webservice.tutorial.webservice.apache.com/}country" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locationDetail" type="{http://webservice.tutorial.webservice.apache.com/}locationDetail" minOccurs="0"/>
 *         &lt;element name="locationDetailList" type="{http://webservice.tutorial.webservice.apache.com/}locationDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locationOutputData", propOrder = {
    "countryList",
    "errorMessage",
    "locationDetail",
    "locationDetailList"
})
public class LocationOutputData {

    @XmlElement(nillable = true)
    protected List<Country> countryList;
    protected String errorMessage;
    protected LocationDetail locationDetail;
    @XmlElement(nillable = true)
    protected List<LocationDetail> locationDetailList;

    /**
     * Gets the value of the countryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Country }
     * 
     * 
     */
    public List<Country> getCountryList() {
        if (countryList == null) {
            countryList = new ArrayList<Country>();
        }
        return this.countryList;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the locationDetail property.
     * 
     * @return
     *     possible object is
     *     {@link LocationDetail }
     *     
     */
    public LocationDetail getLocationDetail() {
        return locationDetail;
    }

    /**
     * Sets the value of the locationDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationDetail }
     *     
     */
    public void setLocationDetail(LocationDetail value) {
        this.locationDetail = value;
    }

    /**
     * Gets the value of the locationDetailList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationDetailList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationDetailList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationDetail }
     * 
     * 
     */
    public List<LocationDetail> getLocationDetailList() {
        if (locationDetailList == null) {
            locationDetailList = new ArrayList<LocationDetail>();
        }
        return this.locationDetailList;
    }

}
