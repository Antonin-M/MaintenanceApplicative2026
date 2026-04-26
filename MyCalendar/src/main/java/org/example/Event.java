package org.example;

import org.example.Object.DateEvent;
import org.example.Object.EventId;
import org.example.Object.Title;
import org.example.Object.Type;

import java.time.LocalDateTime;

public class Event {
    public EventId id;
    public Type type;
    public Title title;
    public String proprietaire;
    public DateEvent date;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(Type type, Title title, String proprietaire, DateEvent date,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.date = date;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals(Type.RDV_PERSONNEL)) {
            desc = "RDV : " + title.title() + " à " + date.dateDebut().toString();
        } else if (type.equals(Type.REUNION)) {
            desc = "Réunion : " + title.title() + " à " + lieu + " avec " + participants;
        } else if (type.equals(Type.PERIODIQUE)) {
            desc = "Événement périodique : " + title.title() + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}