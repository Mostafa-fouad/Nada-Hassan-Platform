package com.example.nadahassanplatform.orders.model;

import com.example.nadahassanplatform.products.model.Product;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = Order.TABLE_NAME)
@TypeDef(name = Order.JSON_B_TYPE, typeClass = JsonBinaryType.class)
public class Order {

    private static final String ORDER_SUBMISSION_ID_COLUMN_NAME = "order_submission_id";
    private static final String ADDRESS_COLUMN_NAME = "address";
    private static final String CUSTOMER_MOBILE_COLUMN_NAME = "customer_mobile";
    private static final String ORDER_ITEMS_COLUMN_NAME = "order_items";
    private static final String CREATION_DATE_COLUMN_NAME = "created_date";
    private static final String UPDATED_DATE_COLUMN_NAME = "updated_date";

    private static final String ORDER_ID_COLUMN_NAME = "order_id";

    static final String JSON_B_TYPE = "jsonb";
    static final String TABLE_NAME = "order";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = ORDER_SUBMISSION_ID_COLUMN_NAME, nullable = false)
    private String orderSubmissionId;

    @Column(name = ADDRESS_COLUMN_NAME, nullable = false)
    private String address;

    @Column(name = CUSTOMER_MOBILE_COLUMN_NAME, nullable = false)
    private String customerMobile;

//    @Type(type = JSON_B_TYPE)
//    @Column(name = ORDER_ITEMS_COLUMN_NAME, nullable = false)
//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<Product> orderItems;

    @CreationTimestamp
    @Column(name = CREATION_DATE_COLUMN_NAME, nullable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = UPDATED_DATE_COLUMN_NAME, nullable = false)
    private Instant updatedDate;
}
