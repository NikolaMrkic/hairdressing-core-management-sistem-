package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
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
@Entity(name = "User")
@Table(name = "hairdresser_user")
public class User extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key userId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "userId")
//    private Long userId;

    /**
     * User to FinishedServices
     */
    @OneToMany(mappedBy = "user")
    private Set<FinishedService> finishedServices = new HashSet<>();

    /**
     * User to Role
     * roleId foregin key
     */
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "roleId")
    private Role role;

    /**
     * User to address
     * addressId foregin key
     */
    @JsonView(View.UserView.class)
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "addressId")
    private Address address;

    /**
     * First Name
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.UserView.class)
    private String firstName;

    /**
     * Last Name
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.UserView.class)
    private String lastName;

    /**
     * Password
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.AdminView.class)
    private String password;

    /**
     * User Name
     */
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
    @JsonView(View.UserView.class)
    private String userName;

    /**
     * Phone
     */
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String phone;

    /**
     * Email
     */
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String email;

//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private Boolean deleted;

    /**
     * Active
     */
    @JsonView(View.UserView.class)
    private Boolean active;

}
