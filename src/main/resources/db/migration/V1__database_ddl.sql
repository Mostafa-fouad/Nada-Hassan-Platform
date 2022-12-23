CREATE TABLE IF NOT EXISTS public.orders
(
    id uuid NOT NULL,
    order_submission_id character varying(255) COLLATE pg_catalog."default",
    address character varying(255) COLLATE pg_catalog."default",
    customer_mobile character varying(12) COLLATE pg_catalog."default",
    order_items jsonb default null::jsonb,
    created_date timestamp without time zone,
    updated_date timestamp without time zone,
    CONSTRAINT order_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.product
(
    id uuid NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    short_description character varying(255) COLLATE pg_catalog."default",
    product_category character varying(255) COLLATE pg_catalog."default",
    primary_image character varying(255) COLLATE pg_catalog."default",
    secondary_images jsonb default null::jsonb,
    price NUMERIC(6, 2),
    quantity int,
    colors jsonb default null::jsonb,
    created_date timestamp without time zone,
    updated_date timestamp without time zone,
    CONSTRAINT product_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS public.internal_user
(
    id uuid NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    user_role character varying(255) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    updated_date timestamp without time zone,
    CONSTRAINT internal_user_pkey PRIMARY KEY (id),
    CONSTRAINT internal_user_email_unique UNIQUE (email)
)

    TABLESPACE pg_default;