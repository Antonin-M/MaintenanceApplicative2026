package org.example.Object;

import org.example.Event;

import java.time.LocalDateTime;

public class RdvPersonnelEvent extends Event {
    public RdvPersonnelEvent(EventId id, Title title, Proprietaire proprietaire, DateEvent date) {
        super(id, Type.RDV_PERSONNEL, title, proprietaire, date, new Lieu(""), new Participants(""), new FrequenceJours(0));
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return estDansIntervalle(debut, fin);
    }

    public String description() {
            return "RDV : " + title.title() + " à " + date.dateDebut().toString();
    }

}
