CREATE TABLE "test_data"
(
    id bigserial
        constraint news_data_pk
            primary key,
    source varchar(255),
    topic varchar(255),
    news varchar(255)
);
