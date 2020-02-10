package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityId;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "Service")
@Table(name = "service")
public class Service extends BaseEntityId {

//    /**
//     * Auto generated database primary key servicesId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    private Long serviceid;

    /**
     * Services to Product
     * product id foregin key
     */
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, optional = true)
    @JsonView(View.UserView.class)
    @JoinColumn(name = "productId")
    private Product product;

    /**
     * Services to Finished Services
     * finishedServicesId foregin key
     */
    //parent
    @ManyToOne
    @JoinColumn(name = "finishedServiceId")
    @JsonView(View.UserView.class)
    private FinishedService finishedService;

    /**
     * Quantity
     */
    private Long quantity;

    /**
     * Date Created
     */
    @NotNull
    private Date dateCreated;
}
