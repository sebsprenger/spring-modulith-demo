package de.sebsprenger.events.incidents.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class PostMortemListener {

    @ApplicationModuleListener
    void on(IncidentCreated event) {
        log.info("EYE-CATCHER: Scheduling post mortem for incident {}", event.id());
    }
}
