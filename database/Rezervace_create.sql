/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.1 		*/
/*  Created On : 27-lis-2018 18:22:32 				*/
/*  DBMS       : Oracle 						*/
/* ---------------------------------------------------- */

/* Drop Triggers, Sequences for Autonumber Columns */

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_R_Stul_Rezervace_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_R_Stul_Rezervace_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_R_Stul_Rezervace_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_R_Stul_Rezervace_ID"'; 
END IF; 
END;
/


DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_R_Ucet_Stul_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_R_Ucet_Stul_ID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_R_Ucet_Stul_ID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_R_Ucet_Stul_ID"'; 
END IF; 
END;
/


DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_Rezervace_RezervaceID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_Rezervace_RezervaceID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_Rezervace_RezervaceID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_Rezervace_RezervaceID"'; 
END IF; 
END;
/


DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_Stav_polozkyID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_Stav_polozkyID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_Stav_polozkyID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_Stav_polozkyID"'; 
END IF; 
END;
/


DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_Stul_StulID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_Stul_StulID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_Stul_StulID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_Stul_StulID"'; 
END IF; 
END;
/


DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_TRIGGERS 
  WHERE TRIGGER_NAME = 'TRG_Ucet_UcetID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP TRIGGER "TRG_Ucet_UcetID"'; 
END IF; 
END;
/

DECLARE 
  C NUMBER; 
BEGIN 
SELECT COUNT(*) INTO C 
FROM USER_SEQUENCES 
  WHERE SEQUENCE_NAME = 'SEQ_Ucet_UcetID'; 
  IF (C > 0) THEN 
    EXECUTE IMMEDIATE 'DROP SEQUENCE "SEQ_Ucet_UcetID"'; 
END IF; 
END;
/


/* Drop Tables */

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "R_Stul_Rezervace" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "R_Ucet_Stul" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "Rezervace" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "Stav_polozky" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "Stul" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

begin
	EXECUTE IMMEDIATE 'DROP TABLE   "Ucet" CASCADE CONSTRAINTS';
	EXCEPTION WHEN OTHERS THEN NULL;
end;
/

/* Create Tables */

CREATE TABLE  "R_Stul_Rezervace"
(
	"RezervaceID" NUMBER(32) NULL,
	"StulID" NUMBER(32) NULL,
	"ID" NUMBER(32) NOT NULL
)
;

CREATE TABLE  "R_Ucet_Stul"
(
	"UcetID" NUMBER(32) NULL,
	"StulID" NUMBER(32) NULL,
	"ID" NUMBER(32) NOT NULL
)
;

CREATE TABLE  "Rezervace"
(
	"Cas_zahajeni" DATE NOT NULL,	-- Presny cas, na kdy je dana rezervace obsazena
	"Cas_ukonceni" DATE NULL,
	"Jmeno" VARCHAR(50) NOT NULL,	-- Jmeno, na koho ma rezervace zaznamenana
	"Pocet_osob" NUMBER(32) NULL,	-- Pocet udava kolik osob bude ocekavano
	"RezervaceID" NUMBER(32) NOT NULL
)
;

CREATE TABLE  "Stav_polozky"
(
	"Cas_vytvoreni" DATE NOT NULL,
	"Stav" VARCHAR(10) NULL,
	"Stav_polozkyID" NUMBER(32) NOT NULL,
	"Polozka_menuID" NUMBER(32) NULL,
	"UcetID" NUMBER(32) NULL
)
;

CREATE TABLE  "Stul"
(
	"Cislo_stolu" VARCHAR(5) NOT NULL,	-- Identifikace konkretniho stolu
	"Pocet_mist" NUMBER(8,2) NULL,	--  Udava kapacitu u daneho stolu
	"StulID" NUMBER(32) NOT NULL
)
;

CREATE TABLE  "Ucet"
(
	"Datum_vytvoreni" DATE NOT NULL,	-- Datum, kdy byl pro zakaznika vystaven ucet
	"Mena" VARCHAR(3) NULL,	-- Mena (CZK/USD/EUR...), ve ktere zakaznik platil
	"Platba_kartou" CHAR(1 BYTE) NOT NULL,
	"Sleva" FLOAT(32) NULL,	-- Informace o tom, zda byla poskytnuta zakaznikovi sleva
	"UcetID" NUMBER(32) NOT NULL
)
;

/* Create Comments, Sequences and Triggers for Autonumber Columns */

CREATE SEQUENCE "SEQ_R_Stul_Rezervace_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_R_Stul_Rezervace_ID" 
	BEFORE INSERT 
	ON "R_Stul_Rezervace" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_R_Stul_Rezervace_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END;

/


CREATE SEQUENCE "SEQ_R_Ucet_Stul_ID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_R_Ucet_Stul_ID" 
	BEFORE INSERT 
	ON "R_Ucet_Stul" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_R_Ucet_Stul_ID".NEXTVAL 
		INTO :NEW."ID" 
		FROM DUAL; 
	END;

/


COMMENT ON TABLE  "Rezervace" IS 'Rezervace je vytvorena pro konkretniho zakaznika na konkretni cas a pocet osob, pote je prirazena konkretnimu stolu nebo stolum, tak aby stoly mely dostatecnou kapacitu pro pocet osob.'
;


COMMENT ON COLUMN  "Rezervace"."Cas_zahajeni" IS 'Presny cas, na kdy je dana rezervace obsazena';

COMMENT ON COLUMN  "Rezervace"."Jmeno" IS 'Jmeno, na koho ma rezervace zaznamenana';

COMMENT ON COLUMN  "Rezervace"."Pocet_osob" IS 'Pocet udava kolik osob bude ocekavano';

CREATE SEQUENCE "SEQ_Rezervace_RezervaceID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_Rezervace_RezervaceID" 
	BEFORE INSERT 
	ON "Rezervace" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_Rezervace_RezervaceID".NEXTVAL 
		INTO :NEW."RezervaceID" 
		FROM DUAL; 
	END;

/


COMMENT ON TABLE  "Stav_polozky" IS 'Pri pridavani polozky z menu na ucet je potreba udrzovat cas jeji pridani a take jeji stav, tzn. zda se pripravuje nebo byla zakaznikovi vydana.'
;


CREATE SEQUENCE "SEQ_Stav_polozkyID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_Stav_polozkyID" 
	BEFORE INSERT 
	ON "Stav_polozky" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_Stav_polozkyID".NEXTVAL 
		INTO :NEW."Stav_polozkyID" 
		FROM DUAL; 
	END;

/


COMMENT ON TABLE  "Stul" IS 'Stul ma urcity pocet mist a jednoznacny identifikator (cislo stolu), aby cisnici vedeli, o ktery stul jde. Stolu je pak prirazen ucet, pokud u nej sedi zakaznik, ktery si neco objednal. Stul muze byt take rezervovana zakaznikem na urcitou dobu a pro urcity pocet osob.'
;


COMMENT ON COLUMN  "Stul"."Cislo_stolu" IS 'Identifikace konkretniho stolu';

COMMENT ON COLUMN  "Stul"."Pocet_mist" IS '
Udava kapacitu u daneho stolu';

CREATE SEQUENCE "SEQ_Stul_StulID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_Stul_StulID" 
	BEFORE INSERT 
	ON "Stul" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_Stul_StulID".NEXTVAL 
		INTO :NEW."StulID" 
		FROM DUAL; 
	END;

/


COMMENT ON TABLE  "Ucet" IS 'Na ucet se pripisuji polozky, ktere si zakaznik objednal. Udzuje si informaci o dobe vytvoreni (cas prvni objednavky), zda je na tento ucet prirazena nejaka sleva a zda byla castka uhrazena kartou nebo v hotovosti. Ucet je prirazen konkretnimu stolu a obsahuje polozky z menu.'
;


COMMENT ON COLUMN  "Ucet"."Datum_vytvoreni" IS 'Datum, kdy byl pro zakaznika vystaven ucet';

COMMENT ON COLUMN  "Ucet"."Mena" IS 'Mena (CZK/USD/EUR...), ve ktere zakaznik platil';

COMMENT ON COLUMN  "Ucet"."Sleva" IS 'Informace o tom, zda byla poskytnuta zakaznikovi sleva';

CREATE SEQUENCE "SEQ_Ucet_UcetID" 
	INCREMENT BY 1 
	START WITH 1 
	NOMAXVALUE 
	MINVALUE  1 
	NOCYCLE 
	NOCACHE 
	NOORDER
;


CREATE OR REPLACE TRIGGER "TRG_Ucet_UcetID" 
	BEFORE INSERT 
	ON "Ucet" 
	FOR EACH ROW 
	BEGIN 
		SELECT "SEQ_Ucet_UcetID".NEXTVAL 
		INTO :NEW."UcetID" 
		FROM DUAL; 
	END;

/


/* Create Primary Keys, Indexes, Uniques, Checks, Triggers */

ALTER TABLE  "R_Stul_Rezervace" 
 ADD CONSTRAINT "PK_R_Stul_Rezervace"
	PRIMARY KEY ("ID") 
 USING INDEX
;

ALTER TABLE  "R_Ucet_Stul" 
 ADD CONSTRAINT "PK_R_Ucet_Stul"
	PRIMARY KEY ("ID") 
 USING INDEX
;

ALTER TABLE  "Rezervace" 
 ADD CONSTRAINT "PK_Rezervace"
	PRIMARY KEY ("RezervaceID") 
 USING INDEX
;

ALTER TABLE  "Stav_polozky" 
 ADD CONSTRAINT "PK_Stav_polozky"
	PRIMARY KEY ("Stav_polozkyID") 
 USING INDEX
;

ALTER TABLE  "Stul" 
 ADD CONSTRAINT "PK_Stul"
	PRIMARY KEY ("StulID") 
 USING INDEX
;

ALTER TABLE  "Ucet" 
 ADD CONSTRAINT "PK_Ucet"
	PRIMARY KEY ("UcetID") 
 USING INDEX
;

/* Create Foreign Key Constraints */

ALTER TABLE  "R_Stul_Rezervace" 
 ADD CONSTRAINT "FK_je_prirazena_STUL"
	FOREIGN KEY ("StulID") REFERENCES  "Stul" ("StulID")
;

ALTER TABLE  "R_Stul_Rezervace" 
 ADD CONSTRAINT "FK_je_prirazena_REZERVACE"
	FOREIGN KEY ("RezervaceID") REFERENCES  "Rezervace" ("RezervaceID")
;

ALTER TABLE  "R_Ucet_Stul" 
 ADD CONSTRAINT "FK_je_prirazen_UCET"
	FOREIGN KEY ("UcetID") REFERENCES  "Ucet" ("UcetID")
;

ALTER TABLE  "R_Ucet_Stul" 
 ADD CONSTRAINT "FK_je_prirazen_STUL"
	FOREIGN KEY ("StulID") REFERENCES  "Stul" ("StulID")
;

ALTER TABLE  "Stav_polozky" 
 ADD CONSTRAINT "FK_STAV_POLOZKY_ma_stav"
	FOREIGN KEY ("Polozka_menuID") REFERENCES  "Polozka_menu" ("Polozka_menuID")
;

ALTER TABLE  "Stav_polozky" 
 ADD CONSTRAINT "FK_STAV_POLOZKY_obsahuje"
	FOREIGN KEY ("UcetID") REFERENCES  "Ucet" ("UcetID")
;
