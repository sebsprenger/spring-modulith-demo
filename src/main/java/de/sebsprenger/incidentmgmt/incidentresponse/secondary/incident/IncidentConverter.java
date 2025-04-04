package de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.Criticality;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Incident;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentId;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Title;

class IncidentConverter {
    static IncidentJpaDto toDto(Incident incident) {
        return IncidentJpaDto.builder()
                .uuid(incident.id().value())
                .name(incident.description().value())
                .criticality(incident.criticality().name())
                .build();
    }

    static Incident toDomain(IncidentJpaDto dto) {
        return new Incident(
                new IncidentId(dto.uuid()),
                new Title(dto.name()),
                Criticality.valueOf(dto.criticality())
        );
    }
}
