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

@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product  extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.AdminView.class)
//    @Column(name = "productId")
//    private Long productId;

    /**
     * Product to Stock
     */
    @JsonView(View.UserView.class)
    @OneToMany(mappedBy = "product")
    private Set<Stock> stockSet = new HashSet<>();

    /**
     * Product to Services
     */
    @JsonView(View.UserView.class)
    @OneToMany(mappedBy = "product")
    private Set<Service> services = new HashSet<>();

    /**
     * Product to specificationValue Collection
     */
    @JsonView(View.UserView.class)
    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<SpecificationValue> specificationValues = new HashSet<>();

//    /**
//     * Product ot Price
//     * priceId foregin key
//     */
//    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
//    private Set<Price> priceSet = new HashSet<>();

    /**
     * Product to Brand
     */
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ProductBrand> productsBrands = new HashSet<>();

    /**
     * Name
     */
    @NotEmpty
    @NotBlank
    @JsonView(View.AdminView.class)
    @Size(min = 1, max = 128)
    private String name;

//    /**
//     * Deleted
//     */
//    @JsonView(View.AdminView.class)
//    private Boolean deleted;

    /**
     * Description short
     */
    @Size(max = 256)
    @JsonView(View.UserView.class)
    private String descriptionShort;

    /**
     * Description Long
     */
    @Size(max = 256)
    @JsonView(View.UserView.class)
    private String descriptionLong;

    /**
     * Product Number
     */
    @JsonView(View.UserView.class)
    private Long productNumber;

    /**
     * Updated Date
     */
    @JsonView(View.UserView.class)
    private Date updatedDate;

    /**
     * Available
     */
    @JsonView(View.AdminView.class)
    private Boolean available;

    /**
     * Note
     */
    @Size(max = 256)
    @JsonView(View.UserView.class)
    private String note;
}
