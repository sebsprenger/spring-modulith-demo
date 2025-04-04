package de.sebsprenger.incidentmgmt.incidentresponse.domain;

public record Incident(IncidentId id, Title description, Criticality criticality) {
}
