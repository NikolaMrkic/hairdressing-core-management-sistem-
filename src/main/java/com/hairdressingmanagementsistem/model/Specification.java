package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import com.hairdressingmanagementsistem.model.enums.SpecificationType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "Specification")
@Table(name = "specification")
public class Specification extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated datatabase primary key specificationId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "specificationId")
//    private Long specificationId;

    /**
     * Specification to SpecificationValueId
     */
    @OneToMany(mappedBy = "specification")
    @JsonView(View.UserView.class)
    private Set<SpecificationValue> specificationValues = new HashSet<>();

    /**
     * Name
     */
    @NotBlank
    @NotEmpty
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String name;

    /**
     * Description
     */
    @Size(max = 128)
    @JsonView(View.UserView.class)
    private String description;

    /**
     * Specification Type
     */
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @JsonView(View.UserView.class)
    private SpecificationType specificationType;

//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private Boolean deleted;
}
