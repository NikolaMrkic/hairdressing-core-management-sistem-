package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "Brand")
@Table(name = "brand")
public class Brand extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key brandId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.AdminView.class)
//    @Column(name = "brandId")
//    private Long brandId;

    /**
     * Brand to Product
     */
    @JsonView(View.UserView.class)
    @OneToMany(
            mappedBy = "brand",
            cascade = CascadeType.ALL,
            orphanRemoval = true

    )
    private Set<ProductBrand> productsBrands = new HashSet<>();

    /**
     * Name
     */
    @NotBlank
    @NotEmpty
    @Size(min = 1, max = 128)
    private String name;

    /**
     * Description
     */
    @Size(min = 1, max = 128)
    private String description;

    /**
     * Updated date
     */
    @JsonView(View.AdminView.class)
    private Date updatedDate;

    /**
     * Available
     */
    @JsonView(View.AdminView.class)
    private Boolean availabe;
//
//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private Boolean deleted;
}
