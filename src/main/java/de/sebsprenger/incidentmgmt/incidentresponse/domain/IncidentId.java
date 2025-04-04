package de.sebsprenger.incidentmgmt.incidentresponse.domain;

import java.util.UUID;

public record IncidentId(UUID value) {

    public static IncidentId newId() {
        return new IncidentId(UUID.randomUUID());
    }

    public static IncidentId fromUuid(String uuid) {
        return new IncidentId(UUID.fromString(uuid));
    }
}
