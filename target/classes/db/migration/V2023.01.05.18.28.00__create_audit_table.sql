CREATE TABLE audit (
    id   INT GENERATED ALWAYS AS IDENTITY
         primary key,
    generated_file_name varchar(255),
    type varchar(255),
    created_date date
);