package org.example;

import org.example.Object.DateEvent;
import org.example.Object.EventId;
import org.example.Object.Title;
import org.example.Object.Type;

import java.time.LocalDateTime;

public abstract class Event {
    public EventId id;
    public Type type;
    public Title title;
    public String proprietaire;
    public DateEvent date;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(EventId id, Type type, Title title, String proprietaire, DateEvent date,
                 String lieu, String participants, int frequenceJours) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.date = date;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    protected boolean estDansIntervalle(LocalDateTime debut, LocalDateTime fin) {
        return !date.dateDebut().isBefore(debut) && !date.dateDebut().isAfter(fin);
    }

    public boolean conflitAvec(Event autreEvent) {
        LocalDateTime fin1 = date.dateDebut().plusMinutes(date.dureeMinutes());
        LocalDateTime fin2 = autreEvent.date.dateDebut().plusMinutes(autreEvent.date.dureeMinutes());
        return date.dateDebut().isBefore(fin2) &&fin1.isAfter(autreEvent.date.dateDebut());
    }

    public abstract boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin);

    public abstract String description();
}