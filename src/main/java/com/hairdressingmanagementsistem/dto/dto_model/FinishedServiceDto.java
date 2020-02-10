package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Company;
import com.hairdressingmanagementsistem.model.Service;
import com.hairdressingmanagementsistem.model.User;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class FinishedServiceDto extends BaseEntityIdAndDeleted implements Serializable {

    /**
     * FinishedServices to User
     */
    @JsonView(View.UserView.class)
    private User user;

    /**
     * FinishedServices to Company collection
     */
    @JsonView(View.UserView.class)
    private Company company;

    /**
     * FinishedServices to Services
     */
    @JsonView(View.UserView.class)
    private Set<Service> services = new HashSet<>();

    /**
     * Date created
     */
    @JsonView(View.UserView.class)
    private Date dateCreated;

}

