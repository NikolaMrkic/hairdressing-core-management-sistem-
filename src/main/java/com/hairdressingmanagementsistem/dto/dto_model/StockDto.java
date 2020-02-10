package com.hairdressingmanagementsistem.dto.dto_model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.Product;
import com.hairdressingmanagementsistem.model.Salon;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import java.io.Serializable;

@Data
public class StockDto extends BaseEntityIdAndDeleted implements Serializable {

    /**
     *  Stock to Product
     *  productId foregin key
     */
    @JsonView(View.UserView.class)
    private Product product;

    /**
     * Stock to Salon
     * salonId foregin key
     */
    @JsonView(View.UserView.class)
    private Salon salon;

    /**
     * Quantity
     */
    @JsonView(View.UserView.class)
    private Double quantity;

}
