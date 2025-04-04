package de.sebsprenger.events.incidents.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class NotificationListener {

    private int counter = 0;

    @ApplicationModuleListener
    void on(IncidentCreated event) {
        failureInjection();
        log.info("EYE-CATCHER: Notifying the management team about incident {}", event);
    }

    private void failureInjection() {
        if (counter++ % 2 == 0) {
            throw new RuntimeException("error");
        }
    }
}
