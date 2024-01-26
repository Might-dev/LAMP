create table lampjdbc.room
(
    id      bigint       not null
        primary key,
    country varchar(255) null,
    name    varchar(255) null,
    on_off  bit          not null
);

