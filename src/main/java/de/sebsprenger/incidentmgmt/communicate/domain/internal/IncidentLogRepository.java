package de.sebsprenger.incidentmgmt.communicate.domain.internal;

import de.sebsprenger.incidentmgmt.communicate.domain.IncidentLog;

public interface IncidentLogRepository {

    void save(IncidentLog incidentLog);
}
