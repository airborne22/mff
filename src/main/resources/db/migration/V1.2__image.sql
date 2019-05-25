CREATE TABLE image
(
    image_id serial PRIMARY KEY,
    base_url varchar(256) DEFAULT NULL,
    path varchar(256) DEFAULT NULL,
    name varchar(256) DEFAULT NULL,

    UNIQUE (path, name)
);

CREATE TABLE character_image
(
    character_image_id serial PRIMARY KEY,
    character_id integer NOT NULL REFERENCES character(character_id),
    image_id integer NOT NULL REFERENCES image(image_id),

    UNIQUE (character_id, image_id)
);