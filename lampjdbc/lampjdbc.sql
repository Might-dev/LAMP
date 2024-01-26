create table lampjdbc.lampjdbc
(
    id      int auto_increment
        primary key,
    name    varchar(32) null,
    country varchar(32) null,
    on_off  tinyint(1)  null
);

