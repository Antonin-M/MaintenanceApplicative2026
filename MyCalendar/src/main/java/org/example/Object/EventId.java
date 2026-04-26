package org.example.Object;

import java.util.UUID;

public record EventId(String value) {

    public static EventId nouveauId() {
        return new EventId(UUID.randomUUID().toString());
    }
}
