package de.sebsprenger.incidentmgmt.communicate.primary.eventlistener;

import de.sebsprenger.incidentmgmt.communicate.application.NotificationApplicationService;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncidentCreationNotificationListener {

    private int counter = 0;

    private final NotificationApplicationService notificationApplicationService;

    @ApplicationModuleListener
    void on(IncidentCreated event) {
        failureInjection();
        notificationApplicationService.notifyInterestedParties(event.id());
    }

    private void failureInjection() {
        if (counter++ % 2 == 1) {
            throw new RuntimeException("error");
        }
    }
}
