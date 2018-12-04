--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.7
-- Dumped by pg_dump version 10.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: stav; Type: TYPE; Schema: public; Owner: -
--

CREATE TYPE stav AS ENUM (
    'otevreny',
    'zavreny',
    'pripraveny'
);


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: menu_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE menu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: menu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE menu (
    id integer DEFAULT nextval('menu_seq'::regclass) NOT NULL,
    platne_od timestamp without time zone NOT NULL,
    platne_do timestamp without time zone,
    jazyk character varying(32)
);


--
-- Name: menu_polozka_menu_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE menu_polozka_menu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: menu_polozka_menu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE menu_polozka_menu (
    id integer DEFAULT nextval('menu_polozka_menu_seq'::regclass) NOT NULL,
    id_menu integer NOT NULL,
    id_polozka_menu integer NOT NULL
);


--
-- Name: polozka_menu_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE polozka_menu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: polozka_menu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE polozka_menu (
    id integer DEFAULT nextval('polozka_menu_seq'::regclass) NOT NULL,
    nazev character varying(64) NOT NULL,
    cena real NOT NULL
);


--
-- Name: popularita_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE popularita_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: popularita; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE popularita (
    id integer DEFAULT nextval('popularita_seq'::regclass) NOT NULL,
    id_polozka_menu integer NOT NULL,
    hodnota real NOT NULL,
    datum timestamp without time zone DEFAULT now() NOT NULL
);


--
-- Name: stav_polozky_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE stav_polozky_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: stav_polozky; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE stav_polozky (
    id integer DEFAULT nextval('stav_polozky_id_seq'::regclass) NOT NULL,
    id_ucet integer NOT NULL,
    id_polozka_menu integer NOT NULL,
    cas_vytvoreni timestamp without time zone DEFAULT now() NOT NULL,
    stav character varying(32) DEFAULT 'otevreny'::character varying
);


--
-- Name: stul_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE stul_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: stul; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE stul (
    id integer DEFAULT nextval('stul_seq'::regclass) NOT NULL,
    cislo_stolu integer NOT NULL,
    pocet_mist integer NOT NULL
);


--
-- Name: stul_ucet_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE stul_ucet_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: stul_ucet; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE stul_ucet (
    id integer DEFAULT nextval('stul_ucet_seq'::regclass) NOT NULL,
    id_stul integer NOT NULL,
    id_ucet integer NOT NULL,
    stav character varying(32) DEFAULT 'otevreny'::character varying
);


--
-- Name: typ_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE typ_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: typ; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE typ (
    id integer DEFAULT nextval('typ_seq'::regclass) NOT NULL,
    nazev character varying(64) NOT NULL
);


--
-- Name: typ_polozka_menu_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE typ_polozka_menu_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: typ_polozka_menu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE typ_polozka_menu (
    id integer DEFAULT nextval('typ_polozka_menu_seq'::regclass) NOT NULL,
    id_typ integer NOT NULL,
    id_polozka_menu integer NOT NULL
);


--
-- Name: ucet_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE ucet_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: ucet; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE ucet (
    id integer DEFAULT nextval('ucet_id_seq'::regclass) NOT NULL,
    datum_vytvoreni timestamp without time zone DEFAULT now() NOT NULL,
    mena character varying(32) DEFAULT 'CZK'::character varying,
    platba_kartou boolean
);


--
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- Name: menu_polozka_menu menu_polozka_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY menu_polozka_menu
    ADD CONSTRAINT menu_polozka_menu_pkey PRIMARY KEY (id);


--
-- Name: polozka_menu polozka_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY polozka_menu
    ADD CONSTRAINT polozka_menu_pkey PRIMARY KEY (id);


--
-- Name: popularita popularita_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY popularita
    ADD CONSTRAINT popularita_pkey PRIMARY KEY (id);


--
-- Name: stav_polozky stav_polozky_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stav_polozky
    ADD CONSTRAINT stav_polozky_pkey PRIMARY KEY (id);


--
-- Name: stul stul_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stul
    ADD CONSTRAINT stul_pkey PRIMARY KEY (id);


--
-- Name: stul_ucet stul_ucet_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stul_ucet
    ADD CONSTRAINT stul_ucet_pkey PRIMARY KEY (id);


--
-- Name: typ typ_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY typ
    ADD CONSTRAINT typ_pkey PRIMARY KEY (id);


--
-- Name: typ_polozka_menu typ_polozka_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY typ_polozka_menu
    ADD CONSTRAINT typ_polozka_menu_pkey PRIMARY KEY (id);


--
-- Name: ucet ucet_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY ucet
    ADD CONSTRAINT ucet_pkey PRIMARY KEY (id);


--
-- Name: menu_polozka_menu menu_polozka_menu_id_menu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY menu_polozka_menu
    ADD CONSTRAINT menu_polozka_menu_id_menu_fkey FOREIGN KEY (id_menu) REFERENCES menu(id);


--
-- Name: menu_polozka_menu menu_polozka_menu_id_polozka_menu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY menu_polozka_menu
    ADD CONSTRAINT menu_polozka_menu_id_polozka_menu_fkey FOREIGN KEY (id_polozka_menu) REFERENCES polozka_menu(id);


--
-- Name: popularita popularita_id_polozka_menu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY popularita
    ADD CONSTRAINT popularita_id_polozka_menu_fkey FOREIGN KEY (id_polozka_menu) REFERENCES polozka_menu(id);


--
-- Name: stav_polozky stav_polozky_id_polozka_menu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stav_polozky
    ADD CONSTRAINT stav_polozky_id_polozka_menu_fkey FOREIGN KEY (id_polozka_menu) REFERENCES polozka_menu(id);


--
-- Name: stav_polozky stav_polozky_id_ucet_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stav_polozky
    ADD CONSTRAINT stav_polozky_id_ucet_fkey FOREIGN KEY (id_ucet) REFERENCES ucet(id);


--
-- Name: stul_ucet stul_ucet_id_stul_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stul_ucet
    ADD CONSTRAINT stul_ucet_id_stul_fkey FOREIGN KEY (id_stul) REFERENCES stul(id);


--
-- Name: stul_ucet stul_ucet_id_ucet_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY stul_ucet
    ADD CONSTRAINT stul_ucet_id_ucet_fkey FOREIGN KEY (id_ucet) REFERENCES ucet(id);


--
-- Name: typ_polozka_menu typ_polozka_menu_id_polozka_menu_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY typ_polozka_menu
    ADD CONSTRAINT typ_polozka_menu_id_polozka_menu_fkey FOREIGN KEY (id_polozka_menu) REFERENCES polozka_menu(id);


--
-- Name: typ_polozka_menu typ_polozka_menu_id_typ_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY typ_polozka_menu
    ADD CONSTRAINT typ_polozka_menu_id_typ_fkey FOREIGN KEY (id_typ) REFERENCES typ(id);


--
-- PostgreSQL database dump complete
--

