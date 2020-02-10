package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.RolePermission;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PermissionDto {

    /**
     * Auto generated database primary key permissionId
     */
    @JsonView(View.AdminView.class)
    private Long prermissionId;

    /**
     * Permission to RolePermission
     */
    @JsonView(View.AdminView.class)
    private Set<RolePermission> rolePermissions = new HashSet<>();

    /**
     * Name
     */
    @JsonView(View.AdminView.class)
    private String name;

    /**
     * Active
     */
    @JsonView(View.AdminView.class)
    private Boolean active;

    /**
     * Delete
     */
    @JsonView(View.AdminView.class)
    private Boolean delete;

    /**
     * Description
     */
    @JsonView(View.AdminView.class)
    private String description;
}
