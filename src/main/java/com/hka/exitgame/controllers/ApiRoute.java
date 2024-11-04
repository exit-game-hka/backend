package com.hka.exitgame.controllers;

public final class ApiRoute {

    public static final String API_VERSION = "/api/v1";

    public static final String AUFGABE_ROUTE = API_VERSION + "/aufgaben";

    public static final String ERGEBNIS_ROUTE = API_VERSION + "/ergebnisse";

    public static final String GEGENSTAND_ROUTE = API_VERSION + "/gegenstaende";

    public static final String INTERAKTION_ROUTE = API_VERSION + "/interaktionen";

    public static final String LOESUNG_ROUTE = API_VERSION + "/loesungen";

    public static final String RAUM_ROUTE = API_VERSION + "/raeume";

    public static final String SPIELER_ROUTE = API_VERSION + "/spieler";

    public static final String SPIELER_FORTSCHRITT_ROUTE = API_VERSION + "/spieler-fortschritt";

    public static final String SEMESTER_ROUTE = API_VERSION + "/semester";

    public static final String VERANSTALTUNG_ROUTE = API_VERSION + "/veranstaltung";

    public static final String STATUS_ROUTE = API_VERSION + "/status";

    public static final String KOMMENTAR_ROUTE = API_VERSION + "/kommentare";

    public static final String NOTIFICATION_REST_ROUTE = API_VERSION + "/notifications/rest";

    public static final String NOTIFICATION_WEBSOCKET_SEND_ROUTE = API_VERSION + "/topic/notifications";

    public static final String NOTIFICATION_WEBSOCKET_RECEIVE_ROUTE = API_VERSION + "/websocket-notifications";

    public static final String FRONTEND_USER_ROUTE = API_VERSION + "/frontend-users";
}
