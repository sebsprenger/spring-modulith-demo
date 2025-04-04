package de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentJpaRepository extends JpaRepository<IncidentJpaDto, UUID> {
}