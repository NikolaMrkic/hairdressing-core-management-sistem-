package com.hairdressingmanagementsistem.model.baseEntitis;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Base Entity for primary Id
 */

@Data
@MappedSuperclass
@EqualsAndHashCode(of = {"id"})
public class BaseEntityId {

    /**
     * Auto generated id in base entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

}
