package de.sebsprenger.incidentmgmt.incidentresponse.application;

import de.sebsprenger.incidentmgmt.incidentresponse.domain.Criticality;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.IncidentCreated;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Title;
import de.sebsprenger.incidentmgmt.user.UserManagementApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.PublishedEvents;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static de.sebsprenger.incidentmgmt.TestConfig.POSTGRES_DOCKER_IMAGE;
import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class IncidentApplicationServiceTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_DOCKER_IMAGE);

    @MockitoBean
    private UserManagementApplicationService userManagement;

    @Autowired
    private IncidentApplicationService incidents;

    @Test
    void verifyEvents(PublishedEvents events) {
        incidents.createIncident(new Title("Test title"), Criticality.MEDIUM);

        var incidentCreated = events.ofType(IncidentCreated.class);

        assertThat(incidentCreated).hasSize(1);
    }

}