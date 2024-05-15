-- Spieler Table
INSERT INTO public.spieler (id, avatar_name)
VALUES
    ('10000000-0000-0000-0000-000000000001', 'Test Spieler 1'),
    ('10000000-0000-0000-0000-000000000002', 'Test Spieler 2'),
    ('10000000-0000-0000-0000-000000000003', 'Test Spieler 3'),
    ('10000000-0000-0000-0000-000000000004', 'Test Spieler 4'),
    ('10000000-0000-0000-0000-000000000005', 'Test Spieler 5')
;

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
    ('30000000-0000-0000-0000-000000000001', 'Beschreibung Aufgabe 1', 'Was versteht man unter ACID ?', 240, 'EXZELLENT. SIE HABEN DIE PLATZHALTER DURCHSCHAUT!', 'SCHAUEN SIE NOCH EINMAL NACH, OB DIE ZAHLEN ALS SUBSTITUTE FUNGIEREN UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000001'),
    ('30000000-0000-0000-0000-000000000002', 'Beschreibung Aufgabe 2', 'Erkläre die Begriffe IP und MAC-Adresse', 240, 'KLASSE! SIE WISSEN, WIE MAN CAESAR CHIFFRE ALS BEISPIEL FÜR SUBSTITUTION ANWENDET!', 'SCHAUEN SIE SICH DAS NOCH EINMAL AN. DER NAME DES CHIFFRE GLEICHT DEM EINES ROEMISCHEN STAATSMANNES', '20000000-0000-0000-0000-000000000002'),
    ('30000000-0000-0000-0000-000000000003', 'Beschreibung Aufgabe 3', 'Erkläre den Begriff "Asynchrone Programmierung"', 240, 'KLASSE! SIE HABEN HERAUSGEFUNDEN, DASS SPARTAS MILITAER ZUR VERSCHLUESSELUNG IHRER NACHRICHT DIE TRANSPOSITION GENUTZT HAT', 'SIE SIND NOCH NICHT GANZ HINTER DAS GEHEIMNIS DER SPARTANISCHEN KRIEGSFUEHRER GELANGT. VERSUCHEN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000003'),
    ('30000000-0000-0000-0000-000000000004', 'Beschreibung Aufgabe 4', 'Was versteht man unter einem Lamda-Ausdruck ?', 240, 'DAS IST RICHTIG! IHNEN MACHT DIE TRANSPOSITION NICHTS VOR!', 'LEIDER STIMMT DAS NICHT GANZ. SCHAUEN SIE SICH ERNEUT AN, WIE VIELE ZEILEN MAN BILDEN MUSS, DAMIT SICH EIN SINNVOLLER SATZ ERGIBT.', '20000000-0000-0000-0000-000000000004'),
    ('30000000-0000-0000-0000-000000000005', 'Beschreibung Aufgabe 5', 'Wer ist ein SCRUM-Master ?', 240, 'SEHR GUT, SIE WISSEN, WIE MAN VERSCHLEIERUNG UND TRANSPOSITION MITEINANDER KOMBINIERT ANWENDET!', 'DAS STIMMT LEIDER NICHT. SCHAUEN SIE SICH AM BESTEN DIE DREI KRYPTOGRAPHISCHEN VERFAHREN AN UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000005'),
    ('30000000-0000-0000-0000-000000000006', 'Beschreibung Aufgabe 6', 'Wer ist ein SCRUM-Master ?', 240, 'SPITZE! SIE KENNEN SICH MIT VERSCHLEIERUNG AUS UND HABEN DAS PASSBILD VON ALAN TURING GEFUNDEN! KLEBEN SIE ES EIN, BEVOR DER PROFESSOR KOMMT!', 'DAS STIMMT LEIDER NICHT. SCHAUEN SIE SICH AM BESTEN AN, WIE VERSCHLEIERUNG FUNKTIONIERT UND PROBIEREN SIE ES ERNEUT!', '20000000-0000-0000-0000-000000000006')
;

-- Loesung Table
INSERT INTO public.loesung (id, wert, aufgabe_fk)
VALUES
    ('40000000-0000-0000-0000-000000000001', 'RAETSEL', '30000000-0000-0000-0000-000000000001'),
    ('40000000-0000-0000-0000-000000000002', 'NACHWEISBARKEIT', '30000000-0000-0000-0000-000000000002'),
    ('40000000-0000-0000-0000-000000000003', 'TRANSPOSITION', '30000000-0000-0000-0000-000000000003'),
    ('40000000-0000-0000-0000-000000000004', 'KRYPTOLOGIE IST KRYPTOGRAPHIE PLUS KRYPTANALYSE!!', '30000000-0000-0000-0000-000000000004'),
    ('40000000-0000-0000-0000-000000000005', 'VERSCHLEIERUNG', '30000000-0000-0000-0000-000000000005'),
    ('40000000-0000-0000-0000-000000000006', 'ALAN TURING KNACKTE DIE ENIGMA', '30000000-0000-0000-0000-000000000006')
;

-- Gegenstand Table
INSERT INTO public.gegenstand (id, beschreibung, hinweis, name, greifbar)
VALUES
    ('50000000-0000-0000-0000-000000000001', 'Gegenstand 1 Beschreibung', 'Gegenstand 1 Hinweis', 'Stein', true),
    ('50000000-0000-0000-0000-000000000002', 'Gegenstand 2 Beschreibung', 'Gegenstand 2 Hinweis', 'Baum', true),
    ('50000000-0000-0000-0000-000000000003', 'Gegenstand 3 Beschreibung', 'Gegenstand 3 Hinweis', 'Tuer', true),
    ('50000000-0000-0000-0000-000000000004', 'Gegenstand 4 Beschreibung', 'Gegenstand 4 Hinweis', 'Mauer', true),
    ('50000000-0000-0000-0000-000000000005', 'Gegenstand 5 Beschreibung', 'Gegenstand 5 Hinweis', 'Haus', true)
;

-- Ergebnis Table
INSERT INTO public.ergebnis (id, spieler_fk, aufgabe_fk, versuch, geloest_in)
VALUES
    ('60000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000001', '30000000-0000-0000-0000-000000000001', 2, 100),
    ('60000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000001', '30000000-0000-0000-0000-000000000002', 2, 80),
    ('60000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000002', '30000000-0000-0000-0000-000000000003', 2, 70),
    ('60000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000003', '30000000-0000-0000-0000-000000000004', 2, 60),
    ('60000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000004', '30000000-0000-0000-0000-000000000005', 2, 40),
    ('60000000-0000-0000-0000-000000000006', '10000000-0000-0000-0000-000000000004', '30000000-0000-0000-0000-000000000005', 2, 20)
;

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
INSERT INTO public.interaktion (id, spieler_fk, gegenstand_fk, typ)
VALUES
    ('70000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000001', '50000000-0000-0000-0000-000000000001', 'HINWEIS_GELESEN'),
    ('70000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000001', '50000000-0000-0000-0000-000000000002', 'AUF_GEGENSTAND_GEKLICKT'),
    ('70000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000002', '50000000-0000-0000-0000-000000000003', 'FRAGE_BEANTWORTET'),
    ('70000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000002', '50000000-0000-0000-0000-000000000004', 'AUF_TASTATUR_GEDRUECKT'),
    ('70000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000003', '50000000-0000-0000-0000-000000000005', 'AUF_TASTATUR_GEDRUECKT'),
    ('70000000-0000-0000-0000-000000000006', '10000000-0000-0000-0000-000000000004', '50000000-0000-0000-0000-000000000006', 'HINWEIS_GELESEN')
;