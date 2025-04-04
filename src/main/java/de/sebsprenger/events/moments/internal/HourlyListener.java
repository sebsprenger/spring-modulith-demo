package de.sebsprenger.events.moments.internal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.modulith.moments.HourHasPassed;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HourlyListener {

    @ApplicationModuleListener
    void on(HourHasPassed event) {
        log.info("EYE-CATCHER: hour has passed {} - need to cleanup DB now", event.getTime());
    }
}
