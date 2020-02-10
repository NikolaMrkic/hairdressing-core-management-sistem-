package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Product;
import com.hairdressingmanagementsistem.model.Specification;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpecificationValueDto extends BaseEntityId implements Serializable {

    /**
     * Specification Value to ProductId
     */
    @JsonView(View.UserView.class)
    private Product product;

    /**
     * Specification Value to SpecificationId
     */

    @JsonView(View.UserView.class)
    public Specification specification;

    /**
     * Value
     */
    @JsonView(View.UserView.class)
    private String value;

}

