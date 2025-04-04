package de.sebsprenger.simple.users.schnubbel;

import de.sebsprenger.simple.users.NoSuchUserFoundException;
import de.sebsprenger.simple.users.UserId;
import de.sebsprenger.simple.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    String getUser(@PathVariable String id) throws NoSuchUserFoundException {
        var user = userService.getUser(new UserId(id));

        return """
                {
                    "user-id": "%s",
                    "name": "%s"
                }
                """.formatted(user.id().value(), user.name());
    }
}
