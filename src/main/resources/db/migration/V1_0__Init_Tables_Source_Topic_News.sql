CREATE TABLE "source"
(
    id bigserial
        constraint source_pk
            primary key,
    name varchar(255)
);

CREATE TABLE "topic"
(
    id bigserial
        constraint topic_pk
            primary key,
    name varchar(255)
);


CREATE TABLE "news"(
                       id bigserial
                           constraint news_pk
                               primary key ,
                       name varchar (255) not null,
                       source_id bigint,
                       FOREIGN KEY (source_id) references "source",
                       topic_id bigint,
                       FOREIGN KEY (topic_id) references "topic"
);