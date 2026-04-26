package org.example.Object;

public record Proprietaire(String value) {
    @Override
    public String toString() {
        return value;
    }
}
