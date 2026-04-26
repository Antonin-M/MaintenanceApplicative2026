package org.example.Object;

public record Lieu(String value) {
    @Override
    public String toString() {
        return value;
    }
}
