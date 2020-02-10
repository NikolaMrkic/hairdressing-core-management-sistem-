package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.RolePermission;
import com.hairdressingmanagementsistem.model.User;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDto {

    /**
     * Auto generated database primary key roleId
     */
    @JsonView(View.AdminView.class)
    private Long roleId;

    /**
     * Role to User Collection
     */
    @JsonView(View.AdminView.class)
    private Set<User> userSet = new HashSet<>();

    /**
     * Role to Role Permission Collection
     * rolePermissionId forgeign key
     */
    @JsonView(View.AdminView.class)
    private Set<RolePermission> rolePermissionSet = new HashSet<>();

    /**
     * Name
     */
    @JsonView(View.AdminView.class)
    private String name;

    /**
     * Description
     */
    @JsonView(View.AdminView.class)
    private String description;

    /**
     * Active
     */
    @JsonView(View.AdminView.class)
    private String active;

    /**
     * Delete
     */
    @JsonView(View.AdminView.class)
    private Boolean delete;

}
