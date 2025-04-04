package de.sebsprenger.incidentmgmt.communicate.application;


import de.sebsprenger.incidentmgmt.incidentresponse.IncidentsFacade;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationApplicationService {

    @Getter
    private int counter = 0;
    private final IncidentsFacade incidents;

    @Transactional
    public void notifyInterestedParties(IncidentId id) {
        var incident = incidents.getIncident(id).orElseThrow();

        var recipients = switch (incident.criticality()) {
            case LOW -> Collections.emptyList();
            case MEDIUM -> List.of("stakeholders");
            case HIGH -> List.of("stakeholders", "first-line-management");
            case GTFO -> List.of("stakeholders", "first-line-management", "director-level-management");
        };

        log.info("EYE-CATCHER: informing " + recipients + " interested in " + incident.description());
        counter++;
    }
}
