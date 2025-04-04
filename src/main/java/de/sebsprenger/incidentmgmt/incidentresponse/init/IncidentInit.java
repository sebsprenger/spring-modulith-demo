package de.sebsprenger.incidentmgmt.incidentresponse.init;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.Criticality;
import de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident.IncidentJpaDto;
import de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident.IncidentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IncidentInit implements ApplicationModuleInitializer {

    private final IncidentJpaRepository incidentRepository;

    @Override
    public void initialize() {
        incidentRepository.save(IncidentJpaDto.builder().uuid(UUID.randomUUID()).name("The small one").criticality(Criticality.LOW.name()).build());
        incidentRepository.save(IncidentJpaDto.builder().uuid(UUID.randomUUID()).name("The medium one").criticality(Criticality.MEDIUM.name()).build());
        incidentRepository.save(IncidentJpaDto.builder().uuid(UUID.randomUUID()).name("The fubar one").criticality(Criticality.GTFO.name()).build());
    }
}
