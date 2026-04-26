package org.example.Object;

import org.example.Event;

public class RdvPersonnelEvent extends Event {
    public RdvPersonnelEvent(EventId id, Title title, String proprietaire, DateEvent date) {
        super(id, Type.RDV_PERSONNEL, title, proprietaire, date, "", "", 0);
    }

    public String description() {
            return "RDV : " + title.title() + " à " + date.dateDebut().toString();
    }

}
