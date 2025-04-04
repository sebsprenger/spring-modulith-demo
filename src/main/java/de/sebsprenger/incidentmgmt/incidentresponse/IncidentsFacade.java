package de.sebsprenger.incidentmgmt.incidentresponse;

import de.sebsprenger.incidentmgmt.incidentresponse.application.IncidentApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncidentsFacade {
    @Delegate
    private final IncidentApplicationService delegate;
}