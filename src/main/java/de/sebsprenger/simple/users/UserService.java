package de.sebsprenger.simple.users;

import de.sebsprenger.simple.users.schnubbel.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(UserId id) throws NoSuchUserFoundException {
        return userRepository.findById(id)
                .orElseThrow(NoSuchUserFoundException::new);
    }
}
