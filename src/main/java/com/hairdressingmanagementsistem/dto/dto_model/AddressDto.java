package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Company;
import com.hairdressingmanagementsistem.model.Salon;
import com.hairdressingmanagementsistem.model.User;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class AddressDto extends BaseEntityId implements Serializable {

    /**
     * Address to User
     * userId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<User> users = new HashSet<>();

    /**
     * Address to Company
     * companyId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<Company> companies = new HashSet<>();

    /**
     * Address to Salon
     * salonId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<Salon> salons = new HashSet<>();

    /**
     Area code
     */
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
    @JsonView(View.UserView.class)
    private String streetAddress;

    /**
     * Parametrized constructor
     * @param areaCode
     * @param city
     * @param floor
     * @param houseNumber
     * @param streetAddress
     */
    public AddressDto( String areaCode, String city, String floor, String houseNumber, String streetAddress) {
        this.areaCode = areaCode;
        this.city = city;
        this.floor = floor;
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
    }

    /**
     * Default constructor
     */
    public AddressDto(){
    }

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
