create table vendor (
      vendor_id           number default vendors_s.nextval not null
    , name                varchar2(300) not null
    , salary              number        not null
    , hire_date           date          not null
    , creation_date       date          not null
    , last_update_date    date          not null
);