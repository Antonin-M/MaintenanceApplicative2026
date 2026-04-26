package org.example.Object;

public record Participants(String value) {

    @Override
    public String toString() {
        return value;
    }
}
