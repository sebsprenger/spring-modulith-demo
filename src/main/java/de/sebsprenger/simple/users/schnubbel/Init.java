package de.sebsprenger.simple.users.schnubbel;

import de.sebsprenger.simple.users.User;
import de.sebsprenger.simple.users.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class Init implements CommandLineRunner {

    private final UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        userRepo.save(new User(new UserId("123"), "Seb"));
    }
}
