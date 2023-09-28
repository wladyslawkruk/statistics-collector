create table if not exists classifier
(
    classifier_id serial PRIMARY KEY,
     event_type varchar(50)
);
CREATE TABLE if not exists event
(
    id SERIAL PRIMARY KEY,
    classifier_id integer REFERENCES classifier (classifier_id),
    event_text text,
    timestamp timestamp
);