package org.example;

import org.example.Object.Type;

import java.time.LocalDateTime;

public class Event {
    public Type type;
    public String title;
    public String proprietaire;
    public LocalDateTime dateDebut;
    public int dureeMinutes;
    public String lieu; // utilisé seulement pour REUNION
    public String participants; // séparés par virgules (pour REUNION uniquement)
    public int frequenceJours; // uniquement pour PERIODIQUE

    public Event(Type type, String title, String proprietaire, LocalDateTime dateDebut, int dureeMinutes,
                 String lieu, String participants, int frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description() {
        String desc = "";
        if (type.equals(Type.RDV_PERSONNEL)) {
            desc = "RDV : " + title + " à " + dateDebut.toString();
        } else if (type.equals(Type.REUNION)) {
            desc = "Réunion : " + title + " à " + lieu + " avec " + participants;
        } else if (type.equals(Type.PERIODIQUE)) {
            desc = "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
        }
        return desc;
    }
}