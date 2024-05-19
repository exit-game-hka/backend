-- auto-generated definition
create table semester
(
    id           uuid not null
        primary key,
    start varchar(255),
    ende varchar(255),
    bezeichnung   varchar(255)
);

alter table semester
    owner to dbadmin;

-- auto-generated definition
create table veranstaltung
(
    id           uuid not null
        primary key,
    name varchar(255),
    bezeichnung   varchar(255),
    beschreibung  varchar
);

alter table veranstaltung
    owner to dbadmin;

-- auto-generated definition
create table raum
(
    id           uuid not null
        primary key,
    beschreibung varchar(255),
    name         varchar(255)
);

alter table raum
    owner to dbadmin;


-- auto-generated definition
create table aufgabe
(
    zeit_zu_loesen integer,
    id             uuid not null
        primary key,
    raum_fk        uuid
        constraint fk4vnd0faebh1479jkrtgc5u5pg
            references raum,
    beschreibung   varchar(255),
    wert           varchar(255),
    erfolg_meldung varchar,
    fehlschlag_meldung varchar
);

alter table aufgabe
    owner to dbadmin;


-- auto-generated definition
create table spieler
(
    id          uuid not null
        primary key,
    avatar_name varchar(255),
    semester_id varchar(255),
    veranstaltung_id varchar
);

alter table spieler
    owner to dbadmin;


-- auto-generated definition
create table ergebnis
(
    geloest_in integer,
    versuch    integer,
    aufgabe_fk uuid
        constraint fkkyeux2yy2ycbmen1u555bcb8u
            references aufgabe,
    id         uuid not null
        primary key,
    spieler_fk uuid
        constraint fkbvno2uvq2ur6gj42cchtit3c3
            references spieler
);

alter table ergebnis
    owner to dbadmin;


-- auto-generated definition
create table gegenstand
(
    greifbar     boolean,
    id           uuid not null
        primary key,
    beschreibung varchar(255),
    hinweis      varchar(255),
    name         varchar(255)
);

alter table gegenstand
    owner to dbadmin;


-- auto-generated definition
create table gegenstand_aufgabe
(
    aufgabe_fk    uuid not null
        constraint fknpofq8lj0lcccmoygol36ynnq
            references aufgabe,
    gegenstand_fk uuid not null
        constraint fkly3i08rwrhlkqneku7sfxp0iq
            references gegenstand
);

alter table gegenstand_aufgabe
    owner to dbadmin;


-- auto-generated definition
create table interaktion
(
    gegenstand_fk uuid,
    id            uuid not null
        primary key,
    spieler_fk    uuid,
    typ           varchar(255)
);

alter table interaktion
    owner to dbadmin;

-- auto-generated definition
create table loesung
(
    aufgabe_fk uuid
        constraint fkprwtbfhv00cifb0bvx18sc49q
            references aufgabe,
    id         uuid not null
        primary key,
    wert       varchar(255)
);

alter table loesung
    owner to dbadmin;

-- auto-generated definition
create table status
(
    id           uuid not null primary key,
    spieler_id   uuid not null,
    semester_id  uuid not null,
    veranstaltung_id   uuid not null,
    spiel_start   varchar(255),
    spiel_ende   varchar(255),
    ist_spiel_beendet   boolean
);

alter table status
    owner to dbadmin;