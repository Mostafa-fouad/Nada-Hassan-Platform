package com.example.nadahassanplatform.products.model;

import com.fasterxml.jackson.annotation.JsonValue;
import javax.persistence.*;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static com.example.nadahassanplatform.products.model.Product.TABLE_NAME;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name = TABLE_NAME)
@TypeDef(name = Product.JSON_B_TYPE, typeClass = JsonBinaryType.class)
public class Product {

    private static final String DESCRIPTION_COLUMN_NAME = "description";
    private static final String SHORT_DESCRIPTION_COLUMN_NAME = "short_description";
    private static final String CATEGORY_COLUMN_NAME = "product_category";
    private static final String PRIMARY_IMAGE_COLUMN_NAME = "primary_image";
    private static final String SECONDARY_IMAGES_COLUMN_NAME = "secondary_images";
    private static final String COLORS_COLUMN_NAME = "colors";
    private static final String CREATION_DATE_COLUMN_NAME = "created_date";
    private static final String UPDATED_DATE_COLUMN_NAME = "updated_date";
    private static final String ORDER_ID_COLUMN_NAME = "order_id";

    static final String JSON_B_TYPE = "jsonb";
    static final String TABLE_NAME = "product";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = DESCRIPTION_COLUMN_NAME, nullable = false)
    private String description;

    @Column(name = SHORT_DESCRIPTION_COLUMN_NAME, nullable = false)
    private String shortDescription;

    @Column(name = PRIMARY_IMAGE_COLUMN_NAME, nullable = false)
    private String primaryImage;

    @Type(type = JSON_B_TYPE)
    @Column(name = SECONDARY_IMAGES_COLUMN_NAME, columnDefinition = JSON_B_TYPE)
    private List<String> secondaryImages;

    @Type(type = JSON_B_TYPE)
    @Column(name = COLORS_COLUMN_NAME, columnDefinition = JSON_B_TYPE)
    private List<String> colors;

    @Enumerated(EnumType.STRING)
    @Column(name = CATEGORY_COLUMN_NAME, nullable = false)
    private Category productCategory;

    @CreationTimestamp
    @Column(name = CREATION_DATE_COLUMN_NAME, nullable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = UPDATED_DATE_COLUMN_NAME, nullable = false)
    private Instant updatedDate;




//    TODO categories should be updated upon nada's request, the below categories are just examples
    public enum Category {
        PULLOVER("PULLOVER"),
        JACKET("JACKET"),
        PANTS("PANTS"),
        CHEMISE("CHEMISE"),
        OTHERS("OTHERS");

        private final String value;

        Category(String value) {
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
    }
}
