package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "Stock")
@Table(name = "stock")
public class Stock extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key stockId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "stockId")
//    @JsonView(View.UserView.class)
//    private Long stockId;

    /**
     *  Stock to Product
     *  productId foregin key
     */
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH,CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "productId")
    @JsonView(View.UserView.class)
    private Product product;

    /**
     * Stock to Salon
     * salonId foregin key
     */
    @JsonView(View.UserView.class)
    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salonId")
    private Salon salon;

    /**
     * Quantity
     */
    @JsonView(View.UserView.class)
    @NotNull
    @PositiveOrZero
    private Double quantity;

//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private  Boolean deleted;
}
