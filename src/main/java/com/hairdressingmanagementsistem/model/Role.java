package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

    /**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "Role")
@Table(name = "role")
public class Role {

     /**
     * Auto generated database primary key roleId
     */
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
     @JsonView(View.AdminView.class)
     @Column(name = "roleId")
     private Long roleId;

    /**
     * Role to User Collection
     */
    @JsonView(View.AdminView.class)
    @OneToMany(mappedBy = "role")
    private Set<User> userSet = new HashSet<>();

    /**
     * Role to Role Permission Collection
     * rolePermissionId forgeign key
     */
    @JsonView(View.AdminView.class)
    @OneToMany(mappedBy = "role")
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
