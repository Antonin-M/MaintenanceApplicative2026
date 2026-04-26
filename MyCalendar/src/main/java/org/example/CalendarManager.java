package org.example;

import org.example.Object.DateEvent;
import org.example.Object.EventId;
import org.example.Object.Title;
import org.example.Object.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    public List<Event> events;

    public CalendarManager() {
        this.events = new ArrayList<>();
    }

    public void ajouterEvent(Type type, Title title, String proprietaire, DateEvent date,
                             String lieu, String participants, int frequenceJours) {

        //J'empêche une durée ou fréquence négative
        if (date.dureeMinutes() <=0) return;
        if (type.equals(Type.PERIODIQUE) && frequenceJours <= 0) return;

        Event e = new Event(type, title, proprietaire, date, lieu, participants, frequenceJours);
        events.add(e);
    }

    public boolean supprimerEvent(EventId id) {
        //TODO
        return true;
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if (e.type.equals(Type.PERIODIQUE)) {
                LocalDateTime temp = e.date.dateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(e);
                        break;
                    }
                    temp = temp.plusDays(e.frequenceJours);
                }
            } else if (!e.date.dateDebut().isBefore(debut) && !e.date.dateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        LocalDateTime fin1 = e1.date.dateDebut().plusMinutes(e1.date.dureeMinutes());
        LocalDateTime fin2 = e2.date.dateDebut().plusMinutes(e2.date.dureeMinutes());

        if (e1.type.equals(Type.PERIODIQUE) || e2.type.equals(Type.PERIODIQUE)) {
            return false; // Simplification abusive
        }

        if (e1.date.dateDebut().isBefore(fin2) && fin1.isAfter(e2.date.dateDebut())) {
            return true;
        }
        return false;
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}