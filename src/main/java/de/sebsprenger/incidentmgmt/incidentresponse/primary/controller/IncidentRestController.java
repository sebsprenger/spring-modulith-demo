package de.sebsprenger.incidentmgmt.incidentresponse.primary.controller;


import de.sebsprenger.incidentmgmt.incidentresponse.application.IncidentApplicationService;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Criticality;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Title;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class IncidentRestController {

    private final IncidentApplicationService applicationService;

    @PostMapping(path = "/incidents", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    String create(@RequestBody IncidentCreateRequestBody body) {
        var title = new Title(body.title());
        var criticality = Criticality.valueOf(body.criticality());
        var incident = applicationService.createIncident(title, criticality);
        return """
                {
                    "id": "%s",
                    "criticality": "%s",
                    "description": "%s"
                }
                """.formatted(incident.id(), incident.criticality(), incident.description());
    }

}
