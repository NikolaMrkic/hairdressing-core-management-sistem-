package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.SpecificationValue;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import com.hairdressingmanagementsistem.model.enums.SpecificationType;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
public class SpecificationDto extends BaseEntityIdAndDeleted {

    /**
     * Specification to SpecificationValueId
     */
    @JsonView(View.UserView.class)
    private Set<SpecificationValue> specificationValues = new HashSet<>();

    /**
     * Name
     */
    @JsonView(View.UserView.class)
    private String name;

    /**
     * Description
     */
    @JsonView(View.UserView.class)
    private String description;

    /**
     * Specification Type
     */
    @Enumerated(EnumType.ORDINAL)
    @JsonView(View.UserView.class)
    private SpecificationType specificationType;

}

