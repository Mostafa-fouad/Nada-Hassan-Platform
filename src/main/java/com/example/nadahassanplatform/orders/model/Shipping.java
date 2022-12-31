package com.example.nadahassanplatform.orders.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = Shipping.SHIPPING_TABLE_NAME)
public class Shipping {

    private static final String ID_COLUMN_NAME = "id";
    private static final String GOVERNMENT_NAME_COLUMN_NAME = "government_name";
    private static final String FEES_COLUMN_NAME = "fees";
    private static final String ID_GENERATOR_NAME = "id_generator";
    private static final String ID_GENERATOR_TABLE_NAME = "ID_GEN";
    private static final String ID_GENERATOR_COLUMN_NAME = "GEN_VAL";
    private static final String ID_GENERATOR_PK_NAME = "GEN_NAME";
    static final String SHIPPING_TABLE_NAME = "shipping";

    @Id
    @TableGenerator(name = ID_GENERATOR_NAME,
                    table = ID_GENERATOR_TABLE_NAME,
                    pkColumnName = ID_GENERATOR_PK_NAME,
                    valueColumnName = ID_GENERATOR_COLUMN_NAME,
                    initialValue = 20)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = ID_GENERATOR_NAME)
    @Column(name = ID_COLUMN_NAME, nullable = false)
    private Long id;

    @Column(name = GOVERNMENT_NAME_COLUMN_NAME, nullable = false)
    private String governmentName;

    @Column(name = FEES_COLUMN_NAME, nullable = false)
    private Double fees;

}
