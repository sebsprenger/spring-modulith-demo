package de.sebsprenger.incidentmgmt.user.secondary;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserJpaDto, Integer> {
}