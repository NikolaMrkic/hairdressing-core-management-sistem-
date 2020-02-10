package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import lombok.Data;

import javax.persistence.*;

/**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "RolePermission")
@Table(name = "rolePermission")
public class RolePermission {

    /**
     * Auto generated database primary key rolePermissionId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonView(View.AdminView.class)
    private Long rolePermissionId;

    /**
     * Role Permission to Permission
     * perrmissionId foreign key
     */
    @JsonView(View.AdminView.class)
    @ManyToOne
    @JoinColumn(name = "permissionId")
    private Permission permission;

    /**
     * Role Permission to Role
     * Role foreign key
     */
    @JsonView(View.AdminView.class)
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, optional = true)
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
