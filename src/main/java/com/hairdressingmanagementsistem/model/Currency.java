package com.hairdressingmanagementsistem.model;

import lombok.Data;

    /**
     * @Data is a convenient shortcut annotation that bundles the features of
     * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
     */

@Data
public class Currency {

    /**
     * Auto generated database primary key currecyId
     */
    private Long currecyId;

    /**
     * Name
     */
    private String name;

    /**
     * Symbol
     */
    private String symbol;
}
