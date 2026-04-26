package org.example.Object;

import org.example.Event;

import java.time.LocalDateTime;

public class AutreEvent extends Event {
    public AutreEvent(EventId id, Title title, String proprietaire, DateEvent date) {
        super(id, Type.AUTRE, title, proprietaire, date, "", "", 0);
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return estDansIntervalle(debut,fin);
    }

    public String description() {
        return "";
    }

}
