package org.example.Object;

import org.example.Event;

public class PeriodiqueEvent extends Event {
    public PeriodiqueEvent(EventId id, Title title, String proprietaire, DateEvent date, int frequenceJours) {
        super(id, Type.PERIODIQUE, title, proprietaire, date, "", "", frequenceJours);
    }

    public String description() {
        return "Événement périodique : " + title.title() + " tous les " + frequenceJours + " jours";
    }

}
