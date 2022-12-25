package com.example.nadahassanplatform.orders.model;

import com.example.nadahassanplatform.orders.util.OrderProduct;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = Orders.TABLE_NAME)
@TypeDef(name = Orders.JSON_B_TYPE, typeClass = JsonBinaryType.class)
public class Orders {

    private static final String ORDER_SUBMISSION_ID_COLUMN_NAME = "order_submission_id";
    private static final String ADDRESS_COLUMN_NAME = "address";
    private static final String ORDER_ITEMS_COLUMN_NAME = "order_items";
    private static final String MOBILE_NUMBER_COLUMN_NAME = "mobile_number";
    private static final String EMAIL_COLUMN_NAME = "email";
    private static final String FIRST_NAME_COLUMN_NAME = "first_name";
    private static final String LAST_NAME_COLUMN_NAME = "last_name";
    private static final String CITY_COLUMN_NAME = "city";
    private static final String GOVERNMENT_COLUMN_NAME = "government";
    private static final String SHIPPING_FEES_COLUMN_NAME = "shipping_fees";
    private static final String ORDER_TOTAL_AMOUNT_COLUMN_NAME = "order_total_amount";
    private static final String ORDER_STATUS_COLUMN_NAME = "order_status";
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

    @Column(name = MOBILE_NUMBER_COLUMN_NAME, nullable = false)
    private String mobileNumber;

    @Type(type = JSON_B_TYPE)
    @Column(name = ORDER_ITEMS_COLUMN_NAME, nullable = false)
    private Map<UUID, OrderProduct> orderItems;

    @Column(name = EMAIL_COLUMN_NAME, nullable = false)
    private String email;

    @Column(name = FIRST_NAME_COLUMN_NAME, nullable = false)
    private String firstName;

    @Column(name = LAST_NAME_COLUMN_NAME, nullable = false)
    private String lastName;

    @Column(name = CITY_COLUMN_NAME, nullable = false)
    private String city;

    @Column(name = GOVERNMENT_COLUMN_NAME, nullable = false)
    private String government;

    @Column(name = SHIPPING_FEES_COLUMN_NAME, nullable = false)
    private Double shippingFees;

    @Column(name = ORDER_TOTAL_AMOUNT_COLUMN_NAME, nullable = false)
    private Double orderTotalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = ORDER_STATUS_COLUMN_NAME, nullable = false)
    private Status orderStatus;

    @CreationTimestamp
    @Column(name = CREATION_DATE_COLUMN_NAME, nullable = false, updatable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = UPDATED_DATE_COLUMN_NAME, nullable = false)
    private Instant updatedDate;

    @PrePersist
    private void prePersist() {
        this.orderStatus = Status.AWAITING_SHIPMENT;
        this.createdDate = Instant.now();
        this.updatedDate = Instant.now();
    }

    @PreUpdate
    private void prePersistUpdatedDate() {
        this.updatedDate = Instant.now();
    }

    public enum Status {
        AWAITING_SHIPMENT("AWAITING_SHIPMENT"), //default order status once submitted
        SHIPPED("SHIPPED"),
        OUT_FOR_DELIVERY("OUT_FOR_DELIVERY"),
        ARRIVED("ARRIVED"),
        CANCELLED("CANCELLED"),
        DECLINED("DECLINED");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static List<Status> getAllStatus() {

            return Arrays.stream(Status.values()).toList();
        }
    }
}
