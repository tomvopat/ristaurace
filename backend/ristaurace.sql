create schema public
;

comment on schema public is 'standard public schema'
;

alter schema public owner to postgres
;

create sequence stul_seq
;

alter sequence stul_seq owner to tottop
;

create sequence ucet_id_seq
;

alter sequence ucet_id_seq owner to tottop
;

create sequence stul_ucet_seq
;

alter sequence stul_ucet_seq owner to tottop
;

create sequence polozka_menu_seq
;

alter sequence polozka_menu_seq owner to tottop
;

create sequence stav_polozky_id_seq
;

alter sequence stav_polozky_id_seq owner to tottop
;

create sequence typ_seq
;

alter sequence typ_seq owner to tottop
;

create sequence typ_polozka_menu_seq
;

alter sequence typ_polozka_menu_seq owner to tottop
;

create sequence menu_seq
;

alter sequence menu_seq owner to tottop
;

create sequence menu_polozka_menu_seq
;

alter sequence menu_polozka_menu_seq owner to tottop
;

create sequence popularita_seq
;

alter sequence popularita_seq owner to tottop
;

create sequence hibernate_sequence
;

alter sequence hibernate_sequence owner to tottop
;

create type stav as enum ('otevreny', 'zavreny', 'pripraveny')
;

alter type stav owner to tottop
;

create table if not exists stul
(
	id integer default nextval('stul_seq'::regclass) not null
		constraint stul_pkey
			primary key,
	cislo_stolu integer not null,
	pocet_mist integer not null
)
;

alter table stul owner to tottop
;

create table if not exists ucet
(
	id integer default nextval('ucet_seq'::regclass) not null
		constraint ucet_pkey
			primary key,
	datum_vytvoreni timestamp default now() not null,
	mena varchar(32) default 'CZK'::character varying,
	platba_kartou boolean
)
;

alter table ucet owner to tottop
;

create table if not exists stul_ucet
(
	id integer default nextval('stul_ucet_seq'::regclass) not null
		constraint stul_ucet_pkey
			primary key,
	id_stul integer not null
		constraint stul_ucet_id_stul_fkey
			references stul,
	id_ucet integer not null
		constraint stul_ucet_id_ucet_fkey
			references ucet,
	stav varchar(32) default 'otevreny'::character varying
)
;

alter table stul_ucet owner to tottop
;

create table if not exists polozka_menu
(
	id integer default nextval('polozka_menu_seq'::regclass) not null
		constraint polozka_menu_pkey
			primary key,
	nazev varchar(64) not null,
	cena real not null
)
;

alter table polozka_menu owner to tottop
;

create table if not exists stav_polozky
(
	id integer default nextval('stav_polozky_seq'::regclass) not null
		constraint stav_polozky_pkey
			primary key,
	id_ucet integer not null
		constraint stav_polozky_id_ucet_fkey
			references ucet,
	id_polozka_menu integer not null
		constraint stav_polozky_id_polozka_menu_fkey
			references polozka_menu,
	cas_vytvoreni timestamp default now() not null,
	stav varchar(32) default 'otevreny'::character varying
)
;

alter table stav_polozky owner to tottop
;

create table if not exists typ
(
	id integer default nextval('typ_seq'::regclass) not null
		constraint typ_pkey
			primary key,
	nazev varchar(64) not null
)
;

alter table typ owner to tottop
;

create table if not exists typ_polozka_menu
(
	id integer default nextval('typ_polozka_menu_seq'::regclass) not null
		constraint typ_polozka_menu_pkey
			primary key,
	id_typ integer not null
		constraint typ_polozka_menu_id_typ_fkey
			references typ,
	id_polozka_menu integer not null
		constraint typ_polozka_menu_id_polozka_menu_fkey
			references polozka_menu
)
;

alter table typ_polozka_menu owner to tottop
;

create table if not exists menu
(
	id integer default nextval('menu_seq'::regclass) not null
		constraint menu_pkey
			primary key,
	platne_od timestamp not null,
	platne_do timestamp,
	jazyk varchar(32)
)
;

alter table menu owner to tottop
;

create table if not exists menu_polozka_menu
(
	id integer default nextval('menu_polozka_menu_seq'::regclass) not null
		constraint menu_polozka_menu_pkey
			primary key,
	id_menu integer not null
		constraint menu_polozka_menu_id_menu_fkey
			references menu,
	id_polozka_menu integer not null
		constraint menu_polozka_menu_id_polozka_menu_fkey
			references polozka_menu
)
;

alter table menu_polozka_menu owner to tottop
;

create table if not exists popularita
(
	id integer default nextval('popularita_seq'::regclass) not null
		constraint popularita_pkey
			primary key,
	id_polozka_menu integer not null
		constraint popularita_id_polozka_menu_fkey
			references polozka_menu,
	hodnota real not null,
	datum timestamp default now() not null
)
;

alter table popularita owner to tottop
;
