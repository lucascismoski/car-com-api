# car-com-api

create sequence xx_cars_s;

create table xx_cars (
      car_id              number default xx_cars_s.nextval not null
    , description         varchar2(300) not null
    , plate_number        varchar2(20)  not null
    , state               varchar2(50)  not null
    , model               varchar2(50)  not null
    , make                varchar2(50)  not null
    , body_style          varchar2(50)  not null
    , assembly            varchar2(50)  not null
    , engine_size         varchar2(50)  not null
    , registration_date   date          not null
    , creation_date       date          not null
    , last_update_date    date          not null
);

create unique index xx_cars_u1 on xx_cars (car_id);

create or replace trigger xx_cars_t1 
before insert or update on xx_cars
referencing old as old new as new
for each row 
begin
    if inserting then
        :new.car_id           := xx_cars_s.nextval;
        :new.creation_date    := sysdate;
        :new.last_update_date := sysdate;
    else       
        :new.last_update_date := sysdate;
    end if;
end;

-------------------------

create sequence xx_vendors_s;

create table xx_vendors (
      vendor_id           number default xx_vendors_s.nextval not null
    , name                varchar2(300) not null
    , salary              number        not null
    , hire_date           date          not null
    , creation_date       date          not null
    , last_update_date    date          not null
);

create unique index xx_vendors_u1 on xx_vendors (vendor_id);

create or replace trigger xx_vendors_t1 
before insert or update on xx_vendors
referencing old as old new as new
for each row 
begin
    if inserting then
        :new.vendor_id        := xx_vendors_s.nextval;
        :new.creation_date    := sysdate;
        :new.last_update_date := sysdate;
    else       
        :new.last_update_date := sysdate;
    end if;
end;

Insert into xx_vendors (VENDOR_ID,NAME,SALARY,HIRE_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (1,'Gabriel',1200,to_timestamp('2018-11-12 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:48','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:48','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into xx_vendors (VENDOR_ID,NAME,SALARY,HIRE_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (2,'Lucas',1100,to_timestamp('2020-12-20 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:51','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:51','YYYY-MM-DD HH24:MI:SS.FF'));

---------------------------

create sequence xx_car_rents_s;

create table xx_car_rents (
      rent_id             number default xx_car_rents_s.nextval not null
    , car_id              number        not null
    , vendor_id           number        not null
    , start_date          date          not null
    , end_date            date          not null
    , value               number        not null
    , creation_date       date          not null
    , last_update_date    date          not null
);

create unique index xx_car_rents_u1 on xx_car_rents (rent_id);
create index xx_car_rents_n1 on xx_car_rents (car_id, vendor_id);

create or replace trigger xx_car_rents_t1 
before insert or update on xx_car_rents
referencing old as old new as new
for each row 
begin
    if inserting then
        :new.rent_id          := xx_car_rents_s.nextval;
        :new.creation_date    := sysdate;
        :new.last_update_date := sysdate;
    else       
        :new.last_update_date := sysdate;
    end if;
end;