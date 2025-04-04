package de.sebsprenger.events.incidents.internal;

import java.util.UUID;

record IncidentCreated(UUID id, Criticality criticality) {

    enum Criticality {
        MEDIUM,
        CRITICAL
    }

    static IncidentCreated create() {
        return new IncidentCreated(UUID.randomUUID(), IncidentCreated.Criticality.CRITICAL);
    }
}
