package org.example.Object;

import org.example.Event;

import java.time.LocalDateTime;

public class ReunionEvent extends Event {
    public ReunionEvent(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants) {
        super(id, Type.REUNION, title, proprietaire, date, lieu, participants, new FrequenceJours(0));
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return estDansIntervalle(debut, fin);
    }

    public String description() {
        return "Réunion : " + title.title() + " à " + lieu + " avec " + participants;
    }

}
