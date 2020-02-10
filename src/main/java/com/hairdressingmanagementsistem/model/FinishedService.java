package com.hairdressingmanagementsistem.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.hairdressingmanagementsistem.configuration.View;
import com.hairdressingmanagementsistem.model.baseEntitis.BaseEntityIdAndDeleted;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

    /**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
@Entity(name = "FinishedService")
@Table(name = "finishedService")
public class FinishedService extends BaseEntityIdAndDeleted {

//    /**
//     * Auto generated database primary key finishedServicesId
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @JsonView(View.UserView.class)
//    @Column(name = "finishedServiceId")
//    private Long finishedServiceId;

    /**
     * FinishedServices to User
     */
    @JsonView(View.UserView.class)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    private User user;

    /**
     * FinishedServices to Company collection
     */
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY, optional = true)
    @JsonView(View.UserView.class)
    @JoinColumn(name = "company")
    private Company company;

    /**
     * FinishedServices to Services
     */
    //child
    @OneToMany(mappedBy = "finishedService", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JsonView(View.UserView.class)
    private Set<Service> services = new HashSet<>();

    /**
     * Date created
     */
    @JsonView(View.UserView.class)
    private Date dateCreated;

//    /**
//     * Deleted
//     */
//    @JsonView(View.UserView.class)
//    private Boolean deleted;

}

