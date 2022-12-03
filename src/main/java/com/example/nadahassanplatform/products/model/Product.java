package com.example.nadahassanplatform.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    private static final String DESCRIPTION_COLUMN_NAME = "description";

    @Id
    private UUID id;

    @Column(name = DESCRIPTION_COLUMN_NAME)
    private String description;
}
