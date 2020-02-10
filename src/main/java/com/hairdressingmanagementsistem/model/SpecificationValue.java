package com.hairdressingmanagementsistem.model;
import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity(name = "SpecificationValue")
@Table(name = "specificationValue")
public class SpecificationValue extends BaseEntityId {

//    /**
//     * Auto generated database primary key
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "specificationValue")
//    private Long specificationValue;

    /**
     * Specification Value to ProductId
     */
    @ManyToOne
    @JsonView(View.UserView.class)
    @JoinColumn(name = "productId")
    private Product product;

    /**
     * Specification Value to SpecificationId
     */

    //PROVERITI cascade TIPOVE
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY,optional = true)
    @JsonView(View.UserView.class)
    @JoinColumn(name = "specificationId")
    public Specification specification;

    /**
     * Value
     */
    @JsonView(View.UserView.class)
    private String value;
}
