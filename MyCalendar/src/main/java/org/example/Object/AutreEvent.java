package org.example.Object;

import org.example.Event;

public class AutreEvent extends Event {
    public AutreEvent(EventId id, Title title, String proprietaire, DateEvent date) {
        super(id, Type.AUTRE, title, proprietaire, date, "", "", 0);
    }

    public String description() {
        return "";
    }

}
