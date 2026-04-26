package org.example.Object;

import org.example.Event;

import java.time.LocalDateTime;

public class PeriodiqueEvent extends Event {
    public PeriodiqueEvent(EventId id, Title title, Proprietaire proprietaire, DateEvent date, FrequenceJours frequenceJours) {
        super(id, Type.PERIODIQUE, title, proprietaire, date, new Lieu(""), new Participants(""), frequenceJours);
    }

    @Override
    public boolean estDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime occur = date.dateDebut();
        while(occur.isBefore(debut)) {
            occur = occur.plusDays(frequenceJours.value());
        }
        return occur.isBefore(fin);
    }

    public String description() {
        return "Événement périodique : " + title.title() + " tous les " + frequenceJours + " jours";
    }

}
