package org.example.Object;

import org.example.Event;

public enum Type {
    RDV_PERSONNEL {
        @Override
        public boolean peutAjouter(DateEvent date, FrequenceJours frequenceJours) {
            return date.dureeMinutes() > 0;
        }

        @Override
        public Event creer(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
            return new RdvPersonnelEvent(id, title, proprietaire, date);
        }
    },
    REUNION {
        @Override
        public boolean peutAjouter(DateEvent date, FrequenceJours frequenceJours) {
            return date.dureeMinutes() > 0;
        }

        @Override
        public Event creer(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
            return new ReunionEvent(id, title, proprietaire, date, lieu, participants);
        }
    },
    PERIODIQUE {
        @Override
        public boolean peutAjouter(DateEvent date, FrequenceJours frequenceJours) {
            return date.dureeMinutes() > 0 && frequenceJours.value() > 0;
        }

        @Override
        public Event creer(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
            return new PeriodiqueEvent(id, title, proprietaire, date, frequenceJours);
        }
    },
    AUTRE {
        @Override
        public boolean peutAjouter(DateEvent date, FrequenceJours frequenceJours) {
            return date.dureeMinutes() > 0;
        }

        @Override
        public Event creer(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
            return new AutreEvent(id, title, proprietaire, date);
        }
    };

    public abstract boolean peutAjouter(DateEvent date, FrequenceJours frequenceJours);

    public abstract Event creer(EventId id, Title title, Proprietaire proprietaire, DateEvent date, Lieu lieu, Participants participants, FrequenceJours frequenceJours);
}
