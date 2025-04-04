package de.sebsprenger.events.incidents.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
class IncidentCreationController {

    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/events")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    String produce() {
        var event = IncidentCreated.create();
        eventPublisher.publishEvent(event);
        log.info("EYE-CATCHER: Incident created: {}", event);
        return """
                {
                    "event-id": "%s"
                }
                """.formatted(event.id());
    }
}
