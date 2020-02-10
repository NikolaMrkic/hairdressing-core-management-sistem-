package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

    /**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "Permission")
@Table(name = "permission")
public class Permission {

    /**
     * Auto generated database primary key permissionId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "permissionId")
    @JsonView(View.AdminView.class)
    private Long prermissionId;

    /**
     * Permission to RolePermission
     */
    @OneToMany(mappedBy="permission" , cascade = {CascadeType.PERSIST,CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonView(View.AdminView.class)
    private Set<RolePermission> rolePermissions = new HashSet<>();

    /**
     * Name
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
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
    @Size(min = 1, max = 128)
    private String description;
}
