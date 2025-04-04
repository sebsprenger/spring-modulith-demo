package de.sebsprenger.simple.greetings;


import de.sebsprenger.simple.users.NoSuchUserFoundException;
import de.sebsprenger.simple.users.UserId;
import de.sebsprenger.simple.users.UserService;
import de.sebsprenger.simple.users.schnubbel.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
class GreetingsController {

    private final UserService userService;
//    Comment in to see violation
//    private final UserRepository userRepository;

    @GetMapping("/hello")
    String hello(@RequestParam String id) throws NoSuchUserFoundException {
        var user = userService.getUser(new UserId(id));
        return """
                hello %s
                timestamp: %s
                """.formatted(user.name(), Instant.now());
    }

}