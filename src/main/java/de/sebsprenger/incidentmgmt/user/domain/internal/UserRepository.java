package de.sebsprenger.incidentmgmt.user.domain.internal;

import de.sebsprenger.incidentmgmt.user.domain.User;
import de.sebsprenger.incidentmgmt.user.domain.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(UserId userId);
    List<User> findAll();
}
