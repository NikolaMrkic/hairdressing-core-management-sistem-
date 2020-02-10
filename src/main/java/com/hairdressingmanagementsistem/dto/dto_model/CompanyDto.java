package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Address;
import com.hairdressingmanagementsistem.model.FinishedService;
import com.hairdressingmanagementsistem.model.Salon;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class CompanyDto extends BaseEntityId implements Serializable {

    /**
     * Company to Address
     */
    @JsonView(View.UserView.class)
    private Address address;

    /**
     * Company to Salon
     * salonId foregin key
     */
    private Set<Salon> salons = new HashSet<>();

    /**
     * Company to FinishedServices
     */
    private Set<FinishedService> finishedServices = new HashSet<>();

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
     * Deleted
     */
    @JsonView(View.UserView.class)
    private Boolean deleted;

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

