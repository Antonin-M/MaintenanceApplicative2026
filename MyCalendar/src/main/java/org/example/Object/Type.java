package org.example.Object;

import org.example.Event;

public enum Type {
    RDV_PERSONNEL {
        @Override
        public Event creer(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants, int frequenceJours) {
            return new RdvPersonnelEvent(id, title, proprietaire, date);
        }
    },
    REUNION {
        @Override
        public Event creer(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants, int frequenceJours) {
            return new ReunionEvent(id, title, proprietaire, date, lieu, participants);
        }
    },
    PERIODIQUE {
        @Override
        public Event creer(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants, int frequenceJours) {
            return new PeriodiqueEvent(id, title, proprietaire, date, frequenceJours);
        }
    },
    AUTRE {
        @Override
        public Event creer(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants, int frequenceJours) {
            return new AutreEvent(id, title, proprietaire, date);
        }
    };

    public abstract Event creer(EventId id, Title title, String proprietaire, DateEvent date, String lieu, String participants, int frequenceJours);
}
