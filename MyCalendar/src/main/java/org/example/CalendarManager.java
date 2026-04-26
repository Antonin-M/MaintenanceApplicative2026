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

        Event e = type.creer(EventId.nouveauId(), title, proprietaire, date, lieu, participants, frequenceJours);
        events.add(e);
    }

    public boolean supprimerEvent(EventId id) {
        return events.removeIf( e -> e.id.equals(id));
    }

    public List<Event> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.stream()
                .filter(e -> e.estDansPeriode(debut, fin))
                .toList();
    }

    public boolean conflit(Event e1, Event e2) {
        return e1.conflitAvec(e2);
    }

    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.description());
        }
    }
}