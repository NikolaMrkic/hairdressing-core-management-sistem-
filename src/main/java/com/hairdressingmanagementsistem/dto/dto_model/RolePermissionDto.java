package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Permission;
import com.hairdressingmanagementsistem.model.Role;
import lombok.Data;

import javax.persistence.*;

@Data
public class RolePermissionDto {

    /**
     * Auto generated database primary key rolePermissionId
     */
    @JsonView(View.AdminView.class)
    private Long rolePermissionId;

    /**
     * Role Permission to Permission
     * perrmissionId foreign key
     */
    @JoinColumn(name = "permissionId")
    private Permission permission;

    /**
     * Role Permission to Role
     * Role foreign key
     */
    @JoinColumn(name = "roleId")
    private Role role;

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
}
