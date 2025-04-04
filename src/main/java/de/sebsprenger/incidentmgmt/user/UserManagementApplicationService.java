package de.sebsprenger.incidentmgmt.user;

import de.sebsprenger.incidentmgmt.user.domain.User;
import de.sebsprenger.incidentmgmt.user.domain.UserId;
import de.sebsprenger.incidentmgmt.user.domain.internal.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserManagementApplicationService {

    private final UserRepository userRepository;

    public Optional<User> getUser(UserId userId) {
        return userRepository.findById(userId);
    }
}
