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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_COLUMN_NAME, nullable = false)
    private Long id;

    @Column(name = GOVERNMENT_NAME_COLUMN_NAME, nullable = false)
    private String governmentName;

    @Column(name = FEES_COLUMN_NAME, nullable = false)
    private Double fees;

    static final String SHIPPING_TABLE_NAME = "shipping";
}
