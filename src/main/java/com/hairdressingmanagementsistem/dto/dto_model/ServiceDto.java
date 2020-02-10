package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.FinishedService;
import com.hairdressingmanagementsistem.model.Product;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ServiceDto extends BaseEntityId implements Serializable {

    /**
     * Auto generated database primary key servicesId
     */
    @JsonView(View.UserView.class)
    private Long serviceid;

    /**
     * Services to Product
     * product id foregin key
     */
    @JsonView(View.UserView.class)
    private Product product;

    /**
     * Services to Finished Services
     * finishedServicesId foregin key
     */
    //parent
    @JsonView(View.UserView.class)
    private FinishedService finishedService;

    /**
     * Quantity
     */
    private Long quantity;

    /**
     * Date Created
     */
    private Date dateCreated;
}
