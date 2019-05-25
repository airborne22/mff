CREATE TABLE character
(
    character_id serial PRIMARY KEY,
    character_uuid varchar(100) NOT NULL UNIQUE,
    name varchar(100) NOT NULL UNIQUE,
    type varchar(100) DEFAULT NULL,
    leadership text DEFAULT NULL,
    t1_passive text DEFAULT NULL,
    t2_passive text DEFAULT NULL,
    t3_ability text DEFAULT NULL,
    is_support boolean DEFAULT false,
    has_reflect boolean DEFAULT false,
    has_debuff boolean DEFAULT false,
    is_native boolean DEFAULT false
);

CREATE TABLE iso
(
    iso_id serial PRIMARY KEY,
    iso_uuid varchar(100) NOT NULL UNIQUE,
    name varchar(100) NOT NULL UNIQUE,
    stat varchar(100) DEFAULT NULL
);

CREATE TABLE iso_set
(
    iso_set_id serial PRIMARY KEY,
    iso_set_uuid varchar(100) NOT NULL UNIQUE,
    name varchar(100) NOT NULL UNIQUE,
    type varchar(100) DEFAULT NULL,
    bonus_stat text DEFAULT NULL
);

CREATE TABLE iso_set_composition
(
    iso_set_composition_id serial PRIMARY KEY,
    iso_set_id integer NOT NULL REFERENCES iso_set(iso_set_id),
    iso_id integer NOT NULL REFERENCES iso(iso_id)
);

CREATE TABLE obelisk
(
    obelisk_id serial PRIMARY KEY,
    obelisk_uuid varchar(100) NOT NULL UNIQUE,
    ctp_name varchar(256) DEFAULT NULL,
    obelisk_hash varchar(256) NOT NULL UNIQUE,
    stat1 text DEFAULT NULL,
    stat2 text DEFAULT NULL,
    stat3 text DEFAULT NULL,
    stat4 text DEFAULT NULL
);

CREATE TABLE character_iso_set
(
    character_iso_set_id serial PRIMARY KEY,
    character_id integer NOT NULL REFERENCES character(character_id),
    iso_set_id integer NOT NULL REFERENCES iso_set(iso_set_id),

    UNIQUE (character_id, iso_set_id)
);

CREATE TABLE character_obelisk
(
    character_obelisk_id serial PRIMARY KEY,
    character_id integer NOT NULL REFERENCES character(character_id),
    obelisk_id integer NOT NULL REFERENCES obelisk(obelisk_id),
    type varchar(100) NOT NULL,

    UNIQUE (character_id, obelisk_id)
);