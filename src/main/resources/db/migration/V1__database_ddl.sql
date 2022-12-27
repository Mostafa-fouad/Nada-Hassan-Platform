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

CREATE TABLE IF NOT EXISTS public.shipping
(
    id int NOT NULL,
    government_name character varying(255) COLLATE pg_catalog."default" not null,
    fees float8 not null,
    CONSTRAINT government_shipping_pkey PRIMARY KEY (government_name)
)
    TABLESPACE pg_default;

INSERT INTO shipping
(id, government_name, fees)
VALUES
    (1, 'القاهرة', 50),
    (2, 'الجيزة', 50),
    (3, 'الأسكندرية', 60),
    (4, 'الدلتا', 60),
    (5, 'الشرقية', 60),
    (6, 'القناة', 60),
    (7, 'البحيرة', 60),
    (8, 'بني سويف', 65),
    (9, 'الفيوم', 65),
    (10, 'سوهاج', 85),
    (11, 'الأقصر', 85),
    (12, 'قنا', 85),
    (13, 'أسوان', 85),
    (14, 'المنيا', 85),
    (15, 'أسيوط', 85),
    (16, 'الغردقة', 85),
    (17, 'مرسى مطروح', 85),
    (18, 'الساحل الشمالي', 85),
    (19, 'العين السخنة', 85),
    (20, 'الوادي الجديد', 100);