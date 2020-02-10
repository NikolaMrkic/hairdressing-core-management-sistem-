package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
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
@Entity(name = "Company")
@Table(name = "company")
public class Company extends BaseEntityId {

//    /**
//     * Auto generated database primary key companyId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    private Long companyId;

    /**
     * Company to Address
     */
    //PROVERITIIiii
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "addressId")
    @JsonView(View.UserView.class)
    private Address address;

    /**
     * Company to Salon
     * salonId foregin key
     */
    @OneToMany(mappedBy = "company")
    private Set<Salon> salons = new HashSet<>();

    /**
     * Company to FinishedServices
     */
    @OneToMany(mappedBy = "company")
    private Set<FinishedService> finishedServices = new HashSet<>();

    /**
     * Name
     */
    @NotEmpty
    @NotBlank
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String name;

    /**
     * Owner
     */
    @NotEmpty
    @NotBlank
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String owner;

    /**
     * Email
     */
    @NotEmpty
    @NotBlank
    @Size(max = 128)
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
    @NotEmpty
    @NotBlank
    @Size(min = 1, max = 128)
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
