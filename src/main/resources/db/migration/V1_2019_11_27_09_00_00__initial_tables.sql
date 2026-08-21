create table parcel (
    id BIGSERIAL PRIMARY KEY,
    parcel_number VARCHAR(50) NOT NULL,
    delivery_date VARCHAR(8) NOT NULL,
    delivery_state VARCHAR(20) NOT NULL,
    address_id INT
);

create table address (
    id BIGSERIAL PRIMARY KEY,
    parcel INT REFERENCES parcel(id),
    street VARCHAR(250),
    zip VARCHAR(250),
    number VARCHAR(250),
    consignee VARCHAR(250)
);

create table checkins (
    id BIGSERIAL PRIMARY KEY,
    location_name VARCHAR(250) NOT NULL,
    parcel_id BIGINT NOT NULL REFERENCES parcel(id),
    checkin_date VARCHAR(8) NOT NULL
);
