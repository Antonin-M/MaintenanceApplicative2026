package org.example.Object;

import org.example.Event;

public class ReunionEvent extends Event {
    public ReunionEvent(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants) {
        super(id, Type.REUNION, title, proprietaire, date, lieu, participants, 0);
    }

    public String description() {
        return "Réunion : " + title.title() + " à " + lieu + " avec " + participants;
    }

}
