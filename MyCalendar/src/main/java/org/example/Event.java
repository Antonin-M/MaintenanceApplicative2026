package org.example;

import org.example.Object.*;

import java.time.LocalDateTime;

public abstract class Event {
    public EventId id;
    public Type type;
    public Title title;
    public Proprietaire proprietaire;
    public DateEvent date;
    public Lieu lieu; // utilisé seulement pour REUNION
    public Participants participants; // séparés par virgules (pour REUNION uniquement)
    public FrequenceJours frequenceJours; // uniquement pour PERIODIQUE

    public Event(EventId id, Type type, Title title, Proprietaire proprietaire, DateEvent date,
                 Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
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