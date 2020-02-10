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
@Entity(name = "Salon")
@Table(name = "salon")
public class Salon extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key officeId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "salonId")
//    private Long salonId;

    /**
     * Salon to Stock
     */
    @OneToMany(mappedBy = "salon")
    private Set<Stock> stocks = new HashSet<>();

    /**
     * Salon to Company
     * companyId foregin key
     *
     */
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY,optional = true)
    @JsonView(View.UserView.class)
    @JoinColumn(name = "companyId")
    private Company company;

    /**
     * Salon to Address
     * addressId foregin key
     */
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY,optional = true)
    @JsonView(View.UserView.class)
    @JoinColumn(name = "addressId")
    private Address address;

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

//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private Boolean deleted;

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
