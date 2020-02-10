package com.hairdressingmanagementsistem.dto.dto_model;
import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Address;
import com.hairdressingmanagementsistem.model.FinishedService;
import com.hairdressingmanagementsistem.model.Role;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto extends BaseEntityIdAndDeleted implements Serializable {

    /**
     * User to FinishedServices
     */
    private Set<FinishedService> finishedServices = new HashSet<>();

    /**
     * User to Role
     * roleId foregin key
     */
    @JoinColumn(name = "roleId")
    private Role role;

    /**
     * User to address
     * addressId foregin key
     */
    @JsonView(View.UserView.class)
    private Address address;

    /**
     * First Name
     */
    @JsonView(View.UserView.class)
    private String firstName;

    /**
     * Last Name
     */
    @JsonView(View.UserView.class)
    private String lastName;

    /**
     * Password
     */
    @JsonView(View.AdminView.class)
    private String password;

    /**
     * User Name
     */
    @JsonView(View.UserView.class)
    private String userName;

    /**
     * Phone
     */
    @JsonView(View.UserView.class)
    private String phone;

    /**
     * Email
     */
    @JsonView(View.UserView.class)
    private String email;

}
