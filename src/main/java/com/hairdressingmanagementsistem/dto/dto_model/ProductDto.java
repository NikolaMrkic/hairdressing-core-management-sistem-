package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Brand;
import com.hairdressingmanagementsistem.model.Service;
import com.hairdressingmanagementsistem.model.SpecificationValue;
import com.hairdressingmanagementsistem.model.Stock;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class ProductDto extends BaseEntityIdAndDeleted implements Serializable {
    /**
     * Product to Stock
     */
    @JsonView(View.UserView.class)
    private Set<Stock> stockSet = new HashSet<>();

    /**
     * Product to Services
     * servicesId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<Service> services = new HashSet<>();

    /**
     * Product to specificationValue
     * specificationValueId foregin key
     */
    @JsonView(View.UserView.class)
    private Set<SpecificationValue> specificationValues = new HashSet<>();


    /**
     * Product to Brand
     * brandId foregin key
     */
    private Set<Brand> brands = new HashSet<>();

    /**
     * Name
     */
    @JsonView(View.UserView.class)
    @Size(min = 1, max = 128)
    private String name;

    /**
     * Description short
     */
    @JsonView(View.UserView.class)
    private String descriptionShort;

    /**
     * Description Long
     */
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
    @JsonView(View.UserView.class)
    private String note;

}

