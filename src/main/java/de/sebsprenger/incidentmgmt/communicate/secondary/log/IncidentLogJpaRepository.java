package de.sebsprenger.incidentmgmt.communicate.secondary.log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IncidentLogJpaRepository extends JpaRepository<IncidentLogJpaDto, UUID> {
}