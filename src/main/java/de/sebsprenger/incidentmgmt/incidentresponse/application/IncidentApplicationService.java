package de.sebsprenger.incidentmgmt.incidentresponse.application;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.*;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.internal.IncidentRepository;
import de.sebsprenger.incidentmgmt.user.UserManagementApplicationService;
import de.sebsprenger.incidentmgmt.user.domain.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IncidentApplicationService {
    private final ApplicationEventPublisher eventPublisher;
    private final IncidentRepository incidentRepository;
//    Comment in to see violation
//    private final UserRepository userRepository;
    private final UserManagementApplicationService userManagement;

    @Transactional
    public Incident createIncident(Title title, Criticality criticality) {
        var user = userManagement.getUser(new UserId(1)).orElse(null);
        log.info("EYE-CATCHER: user: {}", user);

        var incident = new Incident(IncidentId.newId(), title, criticality);
        incidentRepository.save(incident);
        log.info("EYE-CATCHER: created incident: {}", incident);

        var event = new IncidentCreated(incident.id());
        eventPublisher.publishEvent(event);

        return incident;
    }

    public Optional<Incident> getIncident(IncidentId incidentId) {
        return incidentRepository.findById(incidentId);
    }
}