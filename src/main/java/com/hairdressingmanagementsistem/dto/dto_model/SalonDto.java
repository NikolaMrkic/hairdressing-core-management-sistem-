package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Address;
import com.hairdressingmanagementsistem.model.Company;
import com.hairdressingmanagementsistem.model.Stock;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class SalonDto extends BaseEntityIdAndDeleted  implements Serializable {

    /**
     * Salon to Stock
     */
    private Set<Stock> stocks = new HashSet<>();

    /**
     * Salon to Company
     * companyId foregin key
     *
     */
    @JsonView(View.UserView.class)
    private Company company;

    /**
     * Salon to Address
     * addressId foregin key
     */
    @JsonView(View.UserView.class)
    private Address address;

    /**
     * Name
     */
    @JsonView(View.UserView.class)
    private String name;

    /**
     * Owner
     */
    @JsonView(View.UserView.class)
    private String owner;

    /**
     * Email
     */
    @JsonView(View.UserView.class)
    private String email;

    /**
     * Phone 1
     */
    @JsonView(View.UserView.class)
    private String phone1;

    /**
     * Phone 2
     */
    @JsonView(View.UserView.class)
    private String phone2;

    /**
     * Phone 3
     */
    @JsonView(View.UserView.class)
    private String phone3;

}

