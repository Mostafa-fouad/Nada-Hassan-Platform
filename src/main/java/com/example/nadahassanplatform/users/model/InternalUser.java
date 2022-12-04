package com.example.nadahassanplatform.users.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.time.Instant;
import java.util.UUID;

import static com.example.nadahassanplatform.users.model.InternalUser.TABLE_NAME;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = TABLE_NAME)
public class InternalUser {

    private static final String EMAIL_COLUMN_NAME = "email";
    private static final String FIRST_NAME_COLUMN_NAME = "first_name";
    private static final String LAST_NAME_COLUMN_NAME = "last_name";
    private static final String USER_ROLE_COLUMN_NAME = "user_role";
    private static final String CREATION_DATE_COLUMN_NAME = "created_date";
    private static final String UPDATED_DATE_COLUMN_NAME = "updated_date";

    static final String TABLE_NAME = "internal_user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = EMAIL_COLUMN_NAME, nullable = false)
    private String email;

    @Column(name = FIRST_NAME_COLUMN_NAME, nullable = false)
    private String firsName;

    @Column(name = LAST_NAME_COLUMN_NAME, nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = USER_ROLE_COLUMN_NAME, nullable = false)
    private Role userRole;

    @CreationTimestamp
    @Column(name = CREATION_DATE_COLUMN_NAME, nullable = false)
    private Instant createdDate;

    @UpdateTimestamp
    @Column(name = UPDATED_DATE_COLUMN_NAME, nullable = false)
    private Instant updatedDate;

    public enum Role {
        ADMIN("ADMIN"),
        OPERATOR("OPERATOR");

        private final String value;

        Role(String value) {
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
