create table if not exists insurance
(
    uuid           varchar(128) not null,
    insurance_type varchar(128) null,
    vehicle_id     varchar(128) not null,
    constraint `PRIMARY`
    primary key (uuid)
    )
    engine = MyISAM;

create index if not exists FKsm0ii1uxjqx9am3xf216r0a63
    on insurance (vehicle_id);

create table if not exists insurance_book
(
    uuid         varchar(128) not null,
    date_time    datetime     null,
    from_whom    varchar(128) null,
    with_whom    varchar(128) null,
    insurance_id varchar(128) null,
    constraint `PRIMARY`
    primary key (uuid)
    )
    engine = MyISAM;

create index if not exists FKb3xtyqfqhkh8lg4odromxsta3
    on insurance_book (insurance_id);

create table if not exists maintenance
(
    uuid             varchar(128) not null,
    maintenance_dttm datetime     null,
    maintenance_type int          null,
    owner_name       varchar(128) null,
    vehicle_id       varchar(128) null,
    constraint `PRIMARY`
    primary key (uuid)
    )
    engine = MyISAM;

create index if not exists FK1uctvvn1p1y3rp57tq34mao9h
    on maintenance (vehicle_id);

create table if not exists vehicle
(
    uuid             varchar(128) not null,
    color            varchar(30)  null,
    engine_content   varchar(128) null,
    fuel_type        int          null,
    license_plate    varchar(30)  null,
    manufacture_dttm datetime     null,
    model            varchar(30)  null,
    type             int          null,
    vin              varchar(30)  null,
    constraint `PRIMARY`
    primary key (uuid)
    )
    engine = MyISAM;

create table if not exists vignette
(
    uuid            varchar(128) not null,
    date_time       datetime     null,
    vignette_amount bigint       null,
    vignette_type   int          null,
    vehicle_id      varchar(128) not null,
    constraint `PRIMARY`
    primary key (uuid)
    )
    engine = MyISAM;

create index if not exists FK6puo06l3voe67gd56smenaaus
    on vignette (vehicle_id);

