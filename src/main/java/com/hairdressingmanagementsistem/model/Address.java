package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Class without lolbok
 */
@Entity(name = "Address")
@Table(name = "address")
public class Address extends BaseEntityId {

//    /**
//     Auto generated addressId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "addressId")
//    private Long addressId;

    /**
     * Address to User
     * userId foregin key
     */
    @OneToMany(mappedBy = "address")
    private Set<User> users = new HashSet<>();

    /**
     * Address to Company
     * companyId foregin key
     */
    @OneToMany(mappedBy = "address")
    private Set<Company> companies = new HashSet<>();

    /**
     * Address to Salon
     * salonId foregin key
     */
    @OneToMany(mappedBy = "address")
    private Set<Salon> salons = new HashSet<>();

    /**
     Area code
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.UserView.class)
    private String areaCode;

    /**
     City
     */
    @JsonView(View.UserView.class)
    private String city;

    /**
     Floor
     */
    @JsonView(View.UserView.class)
    private String floor;

    /**
     House number
     */
    @JsonView(View.UserView.class)
    private String houseNumber;

    /**
     Street address
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.UserView.class)
    private String streetAddress;

    /**
     * Parametrized constructor
     * @param addressId
     * @param areaCode
     * @param city
     * @param floor
     * @param houseNumber
     * @param streetAddress
     */
    public Address(Long addressId, String areaCode, String city, String floor, String houseNumber, String streetAddress) {
       // this.addressId = addressId;
        this.areaCode = areaCode;
        this.city = city;
        this.floor = floor;
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
    }

    /**
     * Default constructor
     */
    public Address(){
    }

//    /**
//     * Gets addressId
//     * @return
//     */
//    public Long getAddressId() {
//        return addressId;
//    }
//
//    /**
//     * Sets addressId
//     * @param addressId
//     */
//    public void setAddressId(Long addressId) {
//        this.addressId = addressId;
//    }

    /**
     * Gets areaCode
     * @return
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Sets areaCode
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * GetsCity
     * @return
     */
    public String getcity() {
        return city;
    }

    /**
     * SetsCity
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets floor
     * @return
     */
    public String getFloor() {
        return floor;
    }

    /**
     * Sets floor
     * @param floor
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * Gets houseNumber
     * @return
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets houseNumber
     * @param houseNumber
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets StreetAddress
     * @return
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets StreetAddress
     * @param streetAddress
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
}
