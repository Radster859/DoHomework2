/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radloff_859936
 */
public class CalendarFetcher {

    private static final String APPLICATION_NAME
            = "Google Calendar API Java Quickstart";

    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/calendar-java-quickstart");

    private static FileDataStoreFactory DATA_STORE_FACTORY;

    private static final JsonFactory JSON_FACTORY
            = JacksonFactory.getDefaultInstance();

    private static HttpTransport HTTP_TRANSPORT;

    private static final List<String> SCOPES
            = Arrays.asList(CalendarScopes.CALENDAR_READONLY);

    private com.google.api.services.calendar.Calendar service;

    private String flag;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static Credential authorize() throws IOException {
        // Load the secret boi
        InputStream in
                = GoogleCalendar.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets
                = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        GoogleAuthorizationCodeFlow flow
                = new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    public static com.google.api.services.calendar.Calendar
            getCalendarService() throws IOException {
        Credential credential = authorize();
        return new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public CalendarFetcher() {
        try {
            service = getCalendarService();
        } catch (IOException ex) {
            Logger.getLogger(CalendarFetcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String f) {
        flag = f;
    }

    public boolean isWork() {
        try {
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list("primary")
                    .setTimeMax(now)
                    .setTimeMin(now)
                    .setSingleEvents(true)
                    .execute();
            List<Event> items = events.getItems();
            for (Event event : items) {
                DateTime currentTime = new DateTime(new Date(), TimeZone.getDefault());
                DateTime startDateTime = event.getStart().getDateTime();
                DateTime endDateTime = event.getEnd().getDateTime();
                if (event.getSummary().contains(flag)) {
                    if (endDateTime.getValue() >= currentTime.getValue() && startDateTime.getValue() <= currentTime.getValue()) {
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CalendarFetcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
