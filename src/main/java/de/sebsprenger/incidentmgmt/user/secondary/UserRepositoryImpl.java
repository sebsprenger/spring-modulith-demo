package de.sebsprenger.incidentmgmt.user.secondary;


import de.sebsprenger.incidentmgmt.user.domain.User;
import de.sebsprenger.incidentmgmt.user.domain.UserId;
import de.sebsprenger.incidentmgmt.user.domain.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    @Override
    public Optional<User> findById(UserId userId) {
        var dto = jpaRepository.findById(userId.value());
        return dto.map(UserJpaDto::toDomain);
    }

    @Override
    public List<User> findAll() {

        return jpaRepository.findAll().stream()
                .map(UserJpaDto::toDomain)
                .toList();
    }
}
