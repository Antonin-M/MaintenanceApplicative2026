import org.example.CalendarManager;
import org.example.Event;
import org.example.Object.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;


import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TestCalendar {

    @Test
    void addItemInCalendar() {
        CalendarManager calendar = new CalendarManager();
        assertEquals(0, calendar.events.size());

        //TODO REMPLACER USER PAR UN ID
        calendar.ajouterEvent(Type.RDV_PERSONNEL,"rdvPerso","Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 30,"","",0);
        calendar.ajouterEvent(Type.REUNION,"rdvReu","Bob",LocalDateTime.of(2026, 6, 15, 16, 40), 32,"","",0);
        calendar.ajouterEvent(Type.PERIODIQUE,"rdvPerio","Pierre",LocalDateTime.of(2026, 7, 17, 17, 35), 33,"","",2);

        assertEquals(3, calendar.events.size());

        //RDV PERSONNEL
        assertEquals(Type.RDV_PERSONNEL, calendar.events.get(0).type);
        assertEquals("rdvPerso", calendar.events.get(0).title);
        assertEquals("Benoit", calendar.events.get(0).proprietaire);
        assertEquals(LocalDateTime.of(2026, 5, 14, 15, 45), calendar.events.get(0).dateDebut);
        assertEquals(30, calendar.events.get(0).dureeMinutes);
        assertEquals(0, calendar.events.get(0).frequenceJours);

        //RDV REUNION
        assertEquals(Type.REUNION, calendar.events.get(1).type);
        assertEquals("rdvReu", calendar.events.get(1).title);
        assertEquals("Bob", calendar.events.get(1).proprietaire);
        assertEquals(LocalDateTime.of(2026, 6, 15, 16, 40), calendar.events.get(1).dateDebut);
        assertEquals(32, calendar.events.get(1).dureeMinutes);
        assertEquals(0, calendar.events.get(1).frequenceJours);

        //RDV PERIODIQUE
        assertEquals(Type.PERIODIQUE, calendar.events.get(2).type);
        assertEquals("rdvPerio", calendar.events.get(2).title);
        assertEquals("Pierre", calendar.events.get(2).proprietaire);
        assertEquals(LocalDateTime.of(2026, 7, 17, 17, 35), calendar.events.get(2).dateDebut);
        assertEquals(33, calendar.events.get(2).dureeMinutes);
        assertEquals(2, calendar.events.get(2).frequenceJours);
    }

    @Test
    void ErrorAddItemInCalendar() {
        CalendarManager calendar = new CalendarManager();
        assertEquals(0, calendar.events.size());

        //TODO REMPLACER USER PAR UN ID

        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), -5, "", "", 0);
        calendar.ajouterEvent(Type.REUNION, "rdvReu", "Bob", LocalDateTime.of(2026, 6, 15, 16, 40), -32, "", "", 0);
        calendar.ajouterEvent(Type.PERIODIQUE, "rdvPerio", "Pierre", LocalDateTime.of(2026, 7, 17, 17, 35), 33, "", "", -1);

        assertEquals(0, calendar.events.size());
    }

    @Test
    void RecupererVideDansPeriode() {
        CalendarManager calendar = new CalendarManager();
        assertEquals(0, calendar.eventsDansPeriode(LocalDateTime.of(2026, 4, 14, 15, 45), LocalDateTime.of(2026, 6, 14, 15, 45)).size());
    }

    @Test
    void RecupererDansPeriode() {
        CalendarManager calendar = new CalendarManager();
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 35, "", "", 0);
        assertEquals(calendar.events, calendar.eventsDansPeriode(LocalDateTime.of(2026, 4, 14, 15, 45), LocalDateTime.of(2026, 6, 14, 15, 45)));

        assertTrue(calendar.eventsDansPeriode(LocalDateTime.of(2026, 5, 14, 15, 40), LocalDateTime.of(2026, 5, 14, 15, 44)).isEmpty());

        calendar.ajouterEvent(Type.REUNION, "reu", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 35, "", "Bob", 0);
        assertEquals(calendar.events, calendar.eventsDansPeriode(LocalDateTime.of(2026, 4, 14, 15, 45), LocalDateTime.of(2026, 6, 14, 15, 45)));

        calendar.ajouterEvent(Type.PERIODIQUE, "rdvPerio", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 35, "", "", 3);
        assertEquals(calendar.events, calendar.eventsDansPeriode(LocalDateTime.of(2026, 4, 14, 15, 45), LocalDateTime.of(2026, 6, 14, 15, 45)));
        assertEquals(calendar.events.get(2), calendar.eventsDansPeriode(LocalDateTime.of(2026, 6, 14, 15, 45), LocalDateTime.of(2026, 7, 14, 15, 45)).getFirst());

        assertTrue(calendar.eventsDansPeriode(LocalDateTime.of(2027, 6, 14, 13, 45), LocalDateTime.of(2027, 6, 14, 14, 0)).isEmpty());

        assertEquals("RDV : rdvPerso à 2026-05-14T15:45", calendar.events.get(0).description());
        assertEquals("Réunion : reu à  avec Bob", calendar.events.get(1).description());
        assertEquals("Événement périodique : rdvPerio tous les 3 jours", calendar.events.get(2).description());

        calendar.afficherEvenements();
    }

    @Test
    void ConflitHorraireTrue() {
        CalendarManager calendar = new CalendarManager();
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 20, "", "", 0);
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso2", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 50), 35, "", "", 0);
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso3", "Benoit", LocalDateTime.of(2026, 5, 14, 16, 50), 35, "", "", 0);
        assertTrue(calendar.conflit(calendar.events.get(0),calendar.events.get(1)));
        assertFalse(calendar.conflit(calendar.events.get(2),calendar.events.get(1)));

        calendar.ajouterEvent(Type.PERIODIQUE, "rdvPerio", "Benoit", LocalDateTime.of(2026, 5, 11, 15, 45), 35, "", "", 1);
        calendar.ajouterEvent(Type.PERIODIQUE, "rdvPerio2", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 50), 35, "", "", 1);

        //Simplification abusive, a changer lors du refactoring
        assertFalse(calendar.conflit(calendar.events.get(3),calendar.events.get(4)));
        assertFalse(calendar.conflit(calendar.events.get(2),calendar.events.get(3)));
    }

    @Test
    void ConflitHorraireFalse() {
        CalendarManager calendar = new CalendarManager();
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 35, "", "", 0);
        calendar.ajouterEvent(Type.RDV_PERSONNEL, "rdvPerso2", "Benoit", LocalDateTime.of(2026, 6, 14, 15, 45), 35, "", "", 0);
        assertFalse(calendar.conflit(calendar.events.get(0),calendar.events.get(1)));
    }

    @Test
    void RdvSansType() {
        CalendarManager calendar = new CalendarManager();
        calendar.ajouterEvent(Type.AUTRE, "sansType", "Benoit", LocalDateTime.of(2026, 5, 14, 15, 45), 35, "", "", 0);
        assertEquals("", calendar.events.get(0).description());
    }



}
