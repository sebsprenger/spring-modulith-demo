package de.sebsprenger.incidentmgmt.postmortem.primary.eventlistener;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentCreated;
import de.sebsprenger.incidentmgmt.postmortem.application.PostMortems;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IncidentCreatedListener {

    private final PostMortems postMortems;

    @ApplicationModuleListener
    void on(IncidentCreated event) {
        postMortems.createPostMortem(event.id());
    }
}
