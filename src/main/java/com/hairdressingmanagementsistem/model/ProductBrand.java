package com.hairdressingmanagementsistem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity(name = "ProductBrand")
public class ProductBrand implements Serializable {

    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Brand brand;

}
