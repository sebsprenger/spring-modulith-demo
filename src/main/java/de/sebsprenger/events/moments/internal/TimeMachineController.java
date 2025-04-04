package de.sebsprenger.events.moments.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.moments.support.Moments;
import org.springframework.modulith.moments.support.TimeMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TimeMachineController {

    private final TimeMachine timeMachine;
    private final Moments moments;

    @PostMapping("/time/hour")
    String time() {
        timeMachine.shiftBy(Duration.ofHours(1));
        return """
                {
                    "now": "%s"
                }
                """.formatted(timeMachine.now());
    }
}
