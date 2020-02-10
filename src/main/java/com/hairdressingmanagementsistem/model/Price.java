package com.hairdressingmanagementsistem.model;

import lombok.Data;

/**
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */

@Data
public class Price  {

    /**
     * Auto generated database primary key priceId
     */
    private Long priceId;

    /**
     * Price to Currency
     */
    private Currency currency;

    /**
     * Value
     */
    private Long value;
}






