package de.sebsprenger.incidentmgmt.incidentresponse.domain.internal;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.Incident;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentId;

import java.util.List;
import java.util.Optional;

public interface IncidentRepository {

    List<Incident> findAll();

    void save(Incident incident);

    Optional<Incident> findById(IncidentId id);
}
