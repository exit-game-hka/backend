-- Semester Table
INSERT INTO public.semester (id, start, ende, bezeichnung)
VALUES
    ('00000000-0000-0000-0000-000000000001', '2024-03-18T18:22:01.459Z', '2024-08-31T18:22:01.459Z', 'SS24')
;
-- Veranstaltung Table
INSERT INTO public.veranstaltung (id, name, bezeichnung, beschreibung)
VALUES
    ('01000000-0000-0000-0000-000000000001', 'IT-Sicherheit', 'ITS', 'Sicherheit von Informationssysteme'),
    ('01000000-0000-0000-0000-000000000002', 'Kommunikationssyteme', 'KS', 'Netzwerke...'),
    ('01000000-0000-0000-0000-000000000003', 'Kryptographie', 'KRYPTO', 'Krypto...')
;
-- Spieler Table
-- INSERT INTO public.spieler (id, spieler_id, semester_id, veranstaltung_id)
-- VALUES
--     ('10000000-0000-0000-0000-000000000001', '#0000000000001', '00000000-0000-0000-0000-000000000001', '01000000-0000-0000-0000-000000000001'),
--     ('10000000-0000-0000-0000-000000000002', '#0000000000002', '00000000-0000-0000-0000-000000000001', '01000000-0000-0000-0000-000000000001'),
--     ('10000000-0000-0000-0000-000000000003', '#0000000000003', '00000000-0000-0000-0000-000000000001', '01000000-0000-0000-0000-000000000001'),
--     ('10000000-0000-0000-0000-000000000004', '#0000000000004', '00000000-0000-0000-0000-000000000001', '01000000-0000-0000-0000-000000000001'),
--     ('10000000-0000-0000-0000-000000000005', '#0000000000005', '00000000-0000-0000-0000-000000000001', '01000000-0000-0000-0000-000000000001')
-- ;

-- Raum Tables
INSERT INTO public.raum (id, beschreibung, name)
VALUES
    ('20000000-0000-0000-0000-000000000001', 'Beschreibung Raum 1', 'Raum 1'),
    ('20000000-0000-0000-0000-000000000002', 'Beschreibung Raum 2', 'Raum 2'),
    ('20000000-0000-0000-0000-000000000003', 'Beschreibung Raum 3', 'Raum 3'),
    ('20000000-0000-0000-0000-000000000004', 'Beschreibung Raum 4', 'Raum 4'),
    ('20000000-0000-0000-0000-000000000005', 'Beschreibung Raum 5', 'Raum 5'),
    ('20000000-0000-0000-0000-000000000006', 'Beschreibung Raum 6', 'Raum 6')
;

-- Aufgabe Table
-- zeit_zu_loesen in Sekunden
INSERT INTO public.aufgabe (id, beschreibung, wert, zeit_zu_loesen, erfolg_meldung, fehlschlag_meldung, raum_fk)
VALUES
    ('30000000-0000-0000-0000-000000000001', 'Beschreibung Aufgabe 1', 'Was versteht man unter ACID ?', 4, 'EXZELLENT. SIE HABEN DIE PLATZHALTER DURCHSCHAUT!', 'SCHAUEN SIE NOCH EINMAL NACH, OB DIE ZAHLEN ALS SUBSTITUTE FUNGIEREN UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000001'),
    ('30000000-0000-0000-0000-000000000002', 'Beschreibung Aufgabe 2', 'Erkläre die Begriffe IP und MAC-Adresse', 4, 'KLASSE! SIE WISSEN, WIE MAN CAESAR CHIFFRE ALS BEISPIEL FÜR SUBSTITUTION ANWENDET!', 'SCHAUEN SIE SICH DAS NOCH EINMAL AN. DER NAME DES CHIFFRE GLEICHT DEM EINES ROEMISCHEN STAATSMANNES', '20000000-0000-0000-0000-000000000002'),
    ('30000000-0000-0000-0000-000000000003', 'Beschreibung Aufgabe 3', 'Erkläre den Begriff "Asynchrone Programmierung"', 4, 'KLASSE! SIE HABEN HERAUSGEFUNDEN, DASS SPARTAS MILITAER ZUR VERSCHLUESSELUNG IHRER NACHRICHT DIE TRANSPOSITION GENUTZT HAT', 'SIE SIND NOCH NICHT GANZ HINTER DAS GEHEIMNIS DER SPARTANISCHEN KRIEGSFUEHRER GELANGT. VERSUCHEN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000003'),
    ('30000000-0000-0000-0000-000000000004', 'Beschreibung Aufgabe 4', 'Was versteht man unter einem Lamda-Ausdruck ?', 4, 'DAS IST RICHTIG! IHNEN MACHT DIE TRANSPOSITION NICHTS VOR!', 'LEIDER STIMMT DAS NICHT GANZ. SCHAUEN SIE SICH ERNEUT AN, WIE VIELE ZEILEN MAN BILDEN MUSS, DAMIT SICH EIN SINNVOLLER SATZ ERGIBT.', '20000000-0000-0000-0000-000000000004'),
    ('30000000-0000-0000-0000-000000000005', 'Beschreibung Aufgabe 5', 'Wer ist ein SCRUM-Master ?', 4, 'SEHR GUT, SIE WISSEN, WIE MAN VERSCHLEIERUNG UND TRANSPOSITION MITEINANDER KOMBINIERT ANWENDET!', 'DAS STIMMT LEIDER NICHT. SCHAUEN SIE SICH AM BESTEN DIE DREI KRYPTOGRAPHISCHEN VERFAHREN AN UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000005'),
    ('30000000-0000-0000-0000-000000000006', 'Beschreibung Aufgabe 6', 'Wer ist ein SCRUM-Master ?', 4, 'SPITZE! SIE KENNEN SICH MIT VERSCHLEIERUNG AUS UND HABEN DAS PASSBILD VON ALAN TURING GEFUNDEN! KLEBEN SIE ES EIN, BEVOR DER PROFESSOR KOMMT!', 'DAS STIMMT LEIDER NICHT. SCHAUEN SIE SICH AM BESTEN AN, WIE VERSCHLEIERUNG FUNKTIONIERT UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000006')
;

-- Loesung Table
INSERT INTO public.loesung (id, wert, aufgabe_fk)
VALUES
    ('40000000-0000-0000-0000-000000000001', 'RAETSEL', '30000000-0000-0000-0000-000000000001'),
    ('40000000-0000-0000-0000-000000000002', 'NACHWEISBARKEIT', '30000000-0000-0000-0000-000000000002'),
    ('40000000-0000-0000-0000-000000000003', 'TRANSPOSITION', '30000000-0000-0000-0000-000000000003'),
    ('40000000-0000-0000-0000-000000000004', 'KRYPTOLOGIE IST KRYPTOGRAPHIE PLUS KRYPTANALYSE!', '30000000-0000-0000-0000-000000000004'),
    ('40000000-0000-0000-0000-000000000005', 'VERSCHLEIERUNG', '30000000-0000-0000-0000-000000000005'),
    ('40000000-0000-0000-0000-000000000006', 'ALAN TURING KNACKTE DIE ENIGMA', '30000000-0000-0000-0000-000000000006')
;

-- Gegenstand Table
INSERT INTO public.gegenstand (id, beschreibung, hinweis, name, greifbar)
VALUES
    ('50000000-0000-0000-0000-000000000001', 'Gegenstand 1 Beschreibung', 'Gegenstand 1 Hinweis', '', true),
    ('50000000-0000-0000-0000-000000000002', 'Gegenstand 2 Beschreibung', 'Gegenstand 2 Hinweis', '', true),
    ('50000000-0000-0000-0000-000000000003', 'Gegenstand 3 Beschreibung', 'Gegenstand 3 Hinweis', '', true),
    ('50000000-0000-0000-0000-000000000004', 'Gegenstand 4 Beschreibung', 'Gegenstand 4 Hinweis', '', true),
    ('50000000-0000-0000-0000-000000000005', 'Gegenstand 5 Beschreibung', 'Gegenstand 5 Hinweis', '', true)
;

-- Ergebnis Table
-- INSERT INTO public.ergebnis (id, spieler_fk, aufgabe_fk, semester_id, geloest_in)
-- VALUES
--     ('60000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000001', '30000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 100),
--     ('60000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000001', '30000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000001', 80),
--     ('60000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000002', '30000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000001', 70),
--     ('60000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000003', '30000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000001', 60),
--     ('60000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000004', '30000000-0000-0000-0000-000000000005', '00000000-0000-0000-0000-000000000001', 40),
--     ('60000000-0000-0000-0000-000000000006', '10000000-0000-0000-0000-000000000004', '30000000-0000-0000-0000-000000000006', '00000000-0000-0000-0000-000000000001', 20)
-- ;

-- Gegenstand_Aufgabe Table
INSERT INTO public.gegenstand_aufgabe (aufgabe_fk, gegenstand_fk)
VALUES
    ('30000000-0000-0000-0000-000000000001', '50000000-0000-0000-0000-000000000001'),
    ('30000000-0000-0000-0000-000000000002', '50000000-0000-0000-0000-000000000001'),
    ('30000000-0000-0000-0000-000000000002', '50000000-0000-0000-0000-000000000002'),
    ('30000000-0000-0000-0000-000000000003', '50000000-0000-0000-0000-000000000003'),
    ('30000000-0000-0000-0000-000000000004', '50000000-0000-0000-0000-000000000004'),
    ('30000000-0000-0000-0000-000000000005', '50000000-0000-0000-0000-000000000005')
;

-- Interaktion Table
-- INSERT INTO public.interaktion (id, spieler_fk, gegenstand_fk, aufgabe_fk, action)
-- VALUES
--     ('70000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000001', null, '30000000-0000-0000-0000-000000000001', 'HINWEIS_GELESEN'),
--     ('70000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000001', null, '30000000-0000-0000-0000-000000000001', 'AUF_GEGENSTAND_GEKLICKT'),
--     ('70000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000002', null, '30000000-0000-0000-0000-000000000001', 'FRAGE_BEANTWORTET'),
--     ('70000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000002', null, '30000000-0000-0000-0000-000000000002', 'AUF_TASTATUR_GEDRUECKT'),
--     ('70000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000003', null, '30000000-0000-0000-0000-000000000002', 'AUF_TASTATUR_GEDRUECKT'),
--     ('70000000-0000-0000-0000-000000000006', '10000000-0000-0000-0000-000000000004', null, '30000000-0000-0000-0000-000000000003', 'HINWEIS_GELESEN')
-- ;
