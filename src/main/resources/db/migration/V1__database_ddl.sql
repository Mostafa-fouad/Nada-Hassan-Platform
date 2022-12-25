CREATE TABLE IF NOT EXISTS public.orders
(
    id uuid NOT NULL,
    order_submission_id character varying(255) COLLATE pg_catalog."default" not null,
    address character varying(255) COLLATE pg_catalog."default" not null,
    email character varying(255) COLLATE pg_catalog."default" not null,
    first_name character varying(255) COLLATE pg_catalog."default" not null,
    last_name character varying(255) COLLATE pg_catalog."default" not null,
    city character varying(255) COLLATE pg_catalog."default",
    government character varying(255) COLLATE pg_catalog."default" not null,
    mobile_number character varying(12) COLLATE pg_catalog."default" not null,
    order_items jsonb default null::jsonb not null,
    order_total_amount NUMERIC(6, 2) not null,
    shipping_fees NUMERIC(6, 2) not null,
    order_status character varying(255) COLLATE pg_catalog."default" not null,
    created_date timestamp without time zone not null,
    updated_date timestamp without time zone not null,
    CONSTRAINT order_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.product
(
    id uuid NOT NULL,
    description character varying(255) COLLATE pg_catalog."default" not null,
    short_description character varying(255) COLLATE pg_catalog."default" not null,
    product_category character varying(255) COLLATE pg_catalog."default" not null,
    primary_image character varying(255) COLLATE pg_catalog."default" not null,
    secondary_images jsonb default null::jsonb,
    price NUMERIC(6, 2) not null,
    quantity int not null,
    colors jsonb default null::jsonb not null,
    created_date timestamp without time zone not null,
    updated_date timestamp without time zone not null,
    CONSTRAINT product_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.internal_user
(
    id uuid NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" not null,
    first_name character varying(255) COLLATE pg_catalog."default" not null,
    last_name character varying(255) COLLATE pg_catalog."default" not null,
    user_role character varying(255) COLLATE pg_catalog."default" not null,
    created_date timestamp without time zone not null,
    updated_date timestamp without time zone not null,
    CONSTRAINT internal_user_pkey PRIMARY KEY (id),
    CONSTRAINT internal_user_email_unique UNIQUE (email)
)

    TABLESPACE pg_default;