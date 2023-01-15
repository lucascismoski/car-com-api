# car-com-api

create sequence xx_cars_s;

create table xx_cars (
      car_id              number	    not null
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

Insert into "xx_cars" (CAR_ID,DESCRIPTION,PLATE_NUMBER,STATE,MODEL,MAKE,BODY_STYLE,ASSEMBLY,ENGINE_SIZE,REGISTRATION_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (8,'2019 Jeep Grand Cherokee Limited','JEN464','PR (PR)','Grand Cherokee Limited','Jeep','SUV 4D','United States','3.6L V6 MPI',to_timestamp('2019-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:30:01','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:30:01','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into "xx_cars" (CAR_ID,DESCRIPTION,PLATE_NUMBER,STATE,MODEL,MAKE,BODY_STYLE,ASSEMBLY,ENGINE_SIZE,REGISTRATION_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (2,'2016 Chevrolet Silverado 2500 Lt','KPQP33','Florida (FL)','Silverado 2500 Lt','Chevrolet','Double Cab','United States','6.0L V8 SFI',to_timestamp('2016-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:17:08','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:17:08','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into "xx_cars" (CAR_ID,DESCRIPTION,PLATE_NUMBER,STATE,MODEL,MAKE,BODY_STYLE,ASSEMBLY,ENGINE_SIZE,REGISTRATION_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (6,'Kia Sorento Lx','HHT1399','Ohio (OH)','Sorento Lx','Kia','none','none','none',to_timestamp('2015-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:27:29','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:27:29','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into "xx_cars" (CAR_ID,DESCRIPTION,PLATE_NUMBER,STATE,MODEL,MAKE,BODY_STYLE,ASSEMBLY,ENGINE_SIZE,REGISTRATION_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (4,'Toyota 4Runner Sr5/Limited/Trail','8AC799','Minnesota (MN)','4Runner Sr5/Limited/Trail','Toyota','none','none','none',to_timestamp('2014-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:24:59','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:24:59','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into "xx_cars" (CAR_ID,DESCRIPTION,PLATE_NUMBER,STATE,MODEL,MAKE,BODY_STYLE,ASSEMBLY,ENGINE_SIZE,REGISTRATION_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (7,'2018 Nova Bus Rts','1397741','Texas (TX)','Bus Rts','Nova','Low Floor','United States','10.0L L6 Diesel',to_timestamp('2018-01-01 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:28:43','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2023-01-15 22:28:43','YYYY-MM-DD HH24:MI:SS.FF'));

-------------------------

create sequence xx_vendors_s;

create table xx_vendors (
      vendor_id           number        not null
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

Insert into "xx_vendors" (VENDOR_ID,NAME,SALARY,HIRE_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (1,'Gabriel',1200,to_timestamp('2018-11-12 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:48','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:48','YYYY-MM-DD HH24:MI:SS.FF'));
Insert into "xx_vendors" (VENDOR_ID,NAME,SALARY,HIRE_DATE,CREATION_DATE,LAST_UPDATE_DATE) values (2,'Lucas',1100,to_timestamp('2020-12-20 00:00:00','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:51','YYYY-MM-DD HH24:MI:SS.FF'),to_timestamp('2022-11-02 21:01:51','YYYY-MM-DD HH24:MI:SS.FF'));

---------------------------

create sequence xx_car_rents_s;

create table xx_car_rents (
      rent_id             number        not null
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