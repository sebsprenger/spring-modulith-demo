package de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.Incident;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentId;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.internal.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IncidentRepositoryImpl implements IncidentRepository {

    private final IncidentJpaRepository jpaRepository;

    @Override
    public Optional<Incident> findById(IncidentId id) {
        return jpaRepository.findById(id.value())
                .map(IncidentConverter::toDomain);
    }

    @Override
    public List<Incident> findAll() {
        return jpaRepository.findAll().stream()
                .map(IncidentConverter::toDomain)
                .toList();
    }

    @Override
    public void save(Incident incident) {
        jpaRepository.save(IncidentConverter.toDto(incident));
    }
}
