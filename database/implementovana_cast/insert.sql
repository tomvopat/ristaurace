INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Guláš', 109);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Svíčková', 125);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Rizoto', 90);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Pivo', 21);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Voda', 10);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Kuřecí vývar', 35);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Rajčatová polévka', 40);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Hranolky', 10);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Brambory', 10);
INSERT INTO public.polozka_menu (nazev, cena) VALUES ('Kečup', 5);

INSERT INTO public.stul (cislo_stolu, pocet_mist) VALUES (1, 4);
INSERT INTO public.stul (cislo_stolu, pocet_mist) VALUES (2, 2);
INSERT INTO public.stul (cislo_stolu, pocet_mist) VALUES (3, 6);
INSERT INTO public.stul (cislo_stolu, pocet_mist) VALUES (4, 4);
INSERT INTO public.stul (cislo_stolu, pocet_mist) VALUES (5, 3);

INSERT INTO public.typ (nazev) VALUES ('Denní nabídka');
INSERT INTO public.typ (nazev) VALUES ('Nápoje');
INSERT INTO public.typ (nazev) VALUES ('Hlavní chody');
INSERT INTO public.typ (nazev) VALUES ('Polévky');
INSERT INTO public.typ (nazev) VALUES ('Přílohy');

INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (1, 1, 1);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (2, 1, 7);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (3, 2, 4);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (4, 2, 5);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (5, 3, 1);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (6, 3, 2);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (7, 3, 3);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (8, 4, 6);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (9, 4, 7);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (10, 5, 8);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (11, 5, 9);
INSERT INTO public.typ_polozka_menu (id, id_typ, id_polozka_menu) VALUES (12, 5, 10);
