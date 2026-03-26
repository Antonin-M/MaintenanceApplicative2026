package org.example.Object;

import java.time.LocalDateTime;

public class DateEvent {
    private LocalDateTime dateDebut;
    private int dureeMinutes;

    public DateEvent(LocalDateTime dateDebut, int dureeMinutes) {
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDureeMinutes() {
        return dureeMinutes;
    }

    public void setDureeMinutes(int dureeMinutes) {
        this.dureeMinutes = dureeMinutes;
    }
}


