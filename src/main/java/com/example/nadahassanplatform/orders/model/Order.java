package com.example.nadahassanplatform.orders.model;

import com.example.nadahassanplatform.orders.util.OrderProduct;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = Order.TABLE_NAME)
@TypeDef(name = Order.JSON_B_TYPE, typeClass = JsonBinaryType.class)
public class Order {

    private static final String ORDER_SUBMISSION_ID_COLUMN_NAME = "order_submission_id";
    private static final String ADDRESS_COLUMN_NAME = "address";
    private static final String CUSTOMER_MOBILE_COLUMN_NAME = "customer_mobile";
    private static final String CREATION_DATE_COLUMN_NAME = "created_date";
    private static final String UPDATED_DATE_COLUMN_NAME = "updated_date";

    static final String JSON_B_TYPE = "jsonb";
    static final String TABLE_NAME = "orders";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = ORDER_SUBMISSION_ID_COLUMN_NAME, nullable = false)
    private String orderSubmissionId;

    @Column(name = ADDRESS_COLUMN_NAME, nullable = false)
    private String address;

    @Column(name = CUSTOMER_MOBILE_COLUMN_NAME, nullable = false)
    private String customerMobile;

    @Type(type = JSON_B_TYPE)
    private Map<UUID, OrderProduct> orderItems;

    @CreationTimestamp
    @Column(name = CREATION_DATE_COLUMN_NAME, nullable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = UPDATED_DATE_COLUMN_NAME, nullable = false)
    private Instant updatedDate;
}
