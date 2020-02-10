package com.hairdressingmanagementsistem.model.baseEntitis;
import lombok.Data;
import javax.persistence.*;

/**
 * Base Entity for Deleted filed and extends id filed form BaseEntityId
 */

@Data
@MappedSuperclass
public class BaseEntityIdAndDeleted extends BaseEntityId {

    /**
     * Deleted filed in Base Entity
     */
    private Boolean deleted;

}
