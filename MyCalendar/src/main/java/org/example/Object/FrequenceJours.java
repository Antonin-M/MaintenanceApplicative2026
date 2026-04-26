package org.example.Object;

public record FrequenceJours(int value) {
    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
