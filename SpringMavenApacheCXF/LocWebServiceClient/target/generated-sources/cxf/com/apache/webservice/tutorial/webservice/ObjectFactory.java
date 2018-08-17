
package com.apache.webservice.tutorial.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.apache.webservice.tutorial.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetLocationDetail_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getLocationDetail");
    private final static QName _UpdateLocationResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "updateLocationResponse");
    private final static QName _DeleteLocation_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "deleteLocation");
    private final static QName _GetCountryListResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getCountryListResponse");
    private final static QName _UpdateLocation_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "updateLocation");
    private final static QName _GetLocationDetailResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getLocationDetailResponse");
    private final static QName _DeleteLocationResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "deleteLocationResponse");
    private final static QName _GetLocationsResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getLocationsResponse");
    private final static QName _GetCountryList_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getCountryList");
    private final static QName _SaveLocationResponse_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "saveLocationResponse");
    private final static QName _GetLocations_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "getLocations");
    private final static QName _SaveLocation_QNAME = new QName("http://webservice.tutorial.webservice.apache.com/", "saveLocation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.apache.webservice.tutorial.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteLocation }
     * 
     */
    public DeleteLocation createDeleteLocation() {
        return new DeleteLocation();
    }

    /**
     * Create an instance of {@link GetCountryListResponse }
     * 
     */
    public GetCountryListResponse createGetCountryListResponse() {
        return new GetCountryListResponse();
    }

    /**
     * Create an instance of {@link GetLocationDetailResponse }
     * 
     */
    public GetLocationDetailResponse createGetLocationDetailResponse() {
        return new GetLocationDetailResponse();
    }

    /**
     * Create an instance of {@link UpdateLocation }
     * 
     */
    public UpdateLocation createUpdateLocation() {
        return new UpdateLocation();
    }

    /**
     * Create an instance of {@link GetLocationDetail }
     * 
     */
    public GetLocationDetail createGetLocationDetail() {
        return new GetLocationDetail();
    }

    /**
     * Create an instance of {@link UpdateLocationResponse }
     * 
     */
    public UpdateLocationResponse createUpdateLocationResponse() {
        return new UpdateLocationResponse();
    }

    /**
     * Create an instance of {@link GetLocations }
     * 
     */
    public GetLocations createGetLocations() {
        return new GetLocations();
    }

    /**
     * Create an instance of {@link SaveLocation }
     * 
     */
    public SaveLocation createSaveLocation() {
        return new SaveLocation();
    }

    /**
     * Create an instance of {@link DeleteLocationResponse }
     * 
     */
    public DeleteLocationResponse createDeleteLocationResponse() {
        return new DeleteLocationResponse();
    }

    /**
     * Create an instance of {@link GetLocationsResponse }
     * 
     */
    public GetLocationsResponse createGetLocationsResponse() {
        return new GetLocationsResponse();
    }

    /**
     * Create an instance of {@link GetCountryList }
     * 
     */
    public GetCountryList createGetCountryList() {
        return new GetCountryList();
    }

    /**
     * Create an instance of {@link SaveLocationResponse }
     * 
     */
    public SaveLocationResponse createSaveLocationResponse() {
        return new SaveLocationResponse();
    }

    /**
     * Create an instance of {@link Country }
     * 
     */
    public Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link LocationOutputData }
     * 
     */
    public LocationOutputData createLocationOutputData() {
        return new LocationOutputData();
    }

    /**
     * Create an instance of {@link LocationDetail }
     * 
     */
    public LocationDetail createLocationDetail() {
        return new LocationDetail();
    }

    /**
     * Create an instance of {@link LocationInputData }
     * 
     */
    public LocationInputData createLocationInputData() {
        return new LocationInputData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocationDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getLocationDetail")
    public JAXBElement<GetLocationDetail> createGetLocationDetail(GetLocationDetail value) {
        return new JAXBElement<GetLocationDetail>(_GetLocationDetail_QNAME, GetLocationDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "updateLocationResponse")
    public JAXBElement<UpdateLocationResponse> createUpdateLocationResponse(UpdateLocationResponse value) {
        return new JAXBElement<UpdateLocationResponse>(_UpdateLocationResponse_QNAME, UpdateLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "deleteLocation")
    public JAXBElement<DeleteLocation> createDeleteLocation(DeleteLocation value) {
        return new JAXBElement<DeleteLocation>(_DeleteLocation_QNAME, DeleteLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getCountryListResponse")
    public JAXBElement<GetCountryListResponse> createGetCountryListResponse(GetCountryListResponse value) {
        return new JAXBElement<GetCountryListResponse>(_GetCountryListResponse_QNAME, GetCountryListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "updateLocation")
    public JAXBElement<UpdateLocation> createUpdateLocation(UpdateLocation value) {
        return new JAXBElement<UpdateLocation>(_UpdateLocation_QNAME, UpdateLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocationDetailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getLocationDetailResponse")
    public JAXBElement<GetLocationDetailResponse> createGetLocationDetailResponse(GetLocationDetailResponse value) {
        return new JAXBElement<GetLocationDetailResponse>(_GetLocationDetailResponse_QNAME, GetLocationDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "deleteLocationResponse")
    public JAXBElement<DeleteLocationResponse> createDeleteLocationResponse(DeleteLocationResponse value) {
        return new JAXBElement<DeleteLocationResponse>(_DeleteLocationResponse_QNAME, DeleteLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getLocationsResponse")
    public JAXBElement<GetLocationsResponse> createGetLocationsResponse(GetLocationsResponse value) {
        return new JAXBElement<GetLocationsResponse>(_GetLocationsResponse_QNAME, GetLocationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCountryList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getCountryList")
    public JAXBElement<GetCountryList> createGetCountryList(GetCountryList value) {
        return new JAXBElement<GetCountryList>(_GetCountryList_QNAME, GetCountryList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "saveLocationResponse")
    public JAXBElement<SaveLocationResponse> createSaveLocationResponse(SaveLocationResponse value) {
        return new JAXBElement<SaveLocationResponse>(_SaveLocationResponse_QNAME, SaveLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLocations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "getLocations")
    public JAXBElement<GetLocations> createGetLocations(GetLocations value) {
        return new JAXBElement<GetLocations>(_GetLocations_QNAME, GetLocations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.tutorial.webservice.apache.com/", name = "saveLocation")
    public JAXBElement<SaveLocation> createSaveLocation(SaveLocation value) {
        return new JAXBElement<SaveLocation>(_SaveLocation_QNAME, SaveLocation.class, null, value);
    }

}
