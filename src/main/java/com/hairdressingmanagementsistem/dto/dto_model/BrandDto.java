package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Product;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class BrandDto extends BaseEntityIdAndDeleted implements Serializable {

    /**
     * Brand to Product
     * pdoductId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<Product> products = new HashSet<>();

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
     * Updated date
     */
    @JsonView(View.AdminView.class)
    private Date updatedDate;

    /**
     * Available
     */
    @JsonView(View.AdminView.class)
    private Boolean availabe;

}
