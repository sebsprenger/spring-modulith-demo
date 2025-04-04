package de.sebsprenger.simple.users.schnubbel;

import de.sebsprenger.simple.users.User;
import de.sebsprenger.simple.users.UserId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final Map<UserId, User> db = new HashMap<>();

    public Optional<User> findById(UserId id) {
        return Optional.ofNullable(db.get(id));
    }

    void save(User user) {
        db.put(user.id(), user);
    }
}
