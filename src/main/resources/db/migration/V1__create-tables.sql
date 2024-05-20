-- auto-generated definition
create table semester
(
    id              uuid not null primary key,
    start           varchar(255),
    ende            varchar(255),
    bezeichnung     varchar(255)
);

alter table semester
    owner to dbadmin;

-- auto-generated definition
create table veranstaltung
(
    id              uuid not null primary key,
    name            varchar(255),
    bezeichnung     varchar(255),
    beschreibung    varchar
);

alter table veranstaltung
    owner to dbadmin;

-- auto-generated definition
create table raum
(
    id           uuid not null primary key,
    beschreibung varchar(255),
    name         varchar(255)
);

alter table raum
    owner to dbadmin;


-- auto-generated definition
create table aufgabe
(
    id                  uuid not null primary key,
    zeit_zu_loesen      integer,
    raum_fk             uuid constraint aufgabe_raum_idx references raum,
    beschreibung        varchar(255),
    wert                varchar(255),
    erfolg_meldung      varchar,
    fehlschlag_meldung  varchar
);

alter table aufgabe
    owner to dbadmin;


-- auto-generated definition
create table spieler
(
    id                  uuid not null primary key,
    spieler_id          varchar(255) unique not null,
    semester_id         varchar(255),
    veranstaltung_id    varchar
);

alter table spieler
    owner to dbadmin;


-- auto-generated definition
create table ergebnis
(
    id              uuid not null primary key,
    geloest_in      integer,
    versuch         integer,
    aufgabe_fk      uuid constraint ergebnis_aufgabe_idx references aufgabe,
    spieler_fk      uuid constraint ergebnis_spieler_idx references spieler
);

alter table ergebnis
    owner to dbadmin;


-- auto-generated definition
create table gegenstand
(
    greifbar        boolean,
    id              uuid not null primary key,
    beschreibung    varchar(255),
    hinweis         varchar(255),
    name            varchar(255)
);

alter table gegenstand
    owner to dbadmin;


-- auto-generated definition
create table gegenstand_aufgabe
(
    aufgabe_fk    uuid not null constraint gegenstand_aufgabe_aufgabe_idx references aufgabe,
    gegenstand_fk uuid not null constraint gegenstand_aufgabe_gegenstand_idx references gegenstand
);

alter table gegenstand_aufgabe
    owner to dbadmin;


-- auto-generated definition
create table interaktion
(
    id              uuid not null primary key,
    gegenstand_fk   uuid,
    spieler_fk      uuid,
    aufgabe_fk      uuid,
    action          varchar
);

alter table interaktion
    owner to dbadmin;

-- auto-generated definition
create table loesung
(
    aufgabe_fk  uuid constraint loesung_aufgabe_idx references aufgabe,
    id          uuid not null primary key,
    wert        varchar(255)
);

alter table loesung
    owner to dbadmin;

-- auto-generated definition
create table status
(
    id                      uuid not null primary key,
    spieler_id              uuid not null,
    semester_id             uuid not null,
    veranstaltung_id        uuid not null,
    spiel_start             varchar(255),
    spiel_ende              varchar(255),
    ist_spiel_beendet       boolean,
    ist_spiel_abgebrochen   boolean
);

alter table status
    owner to dbadmin;