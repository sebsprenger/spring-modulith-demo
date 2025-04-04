package de.sebsprenger.incidentmgmt.postmortem.application;

import de.sebsprenger.incidentmgmt.incidentresponse.IncidentsFacade;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostMortems {

    private final IncidentsFacade incidents;
//    private final UserManagementApplicationService userService;

    public void createPostMortem(IncidentId incidentId) {
        var incident = incidents.getIncident(incidentId);
        log.info("EYE-CATCHER: scheduling a post mortem for {}", incident);
    }
}
