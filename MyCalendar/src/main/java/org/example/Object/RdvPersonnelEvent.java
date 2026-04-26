package org.example.Object;

import org.example.Event;

import java.time.LocalDateTime;

public class RdvPersonnelEvent extends Event {
    public RdvPersonnelEvent(EventId id, Title title, String proprietaire, DateEvent date) {
        super(id, Type.RDV_PERSONNEL, title, proprietaire, date, "", "", 0);
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return estDansIntervalle(debut, fin);
    }

    public String description() {
            return "RDV : " + title.title() + " à " + date.dateDebut().toString();
    }

}
