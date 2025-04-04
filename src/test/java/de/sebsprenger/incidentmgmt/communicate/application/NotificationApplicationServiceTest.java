package de.sebsprenger.incidentmgmt.communicate.application;

import de.sebsprenger.incidentmgmt.incidentresponse.IncidentsFacade;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import static de.sebsprenger.incidentmgmt.TestConfig.POSTGRES_DOCKER_IMAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode.STANDALONE;

@ApplicationModuleTest(STANDALONE)
class NotificationApplicationServiceTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_DOCKER_IMAGE);

    @MockitoBean
    private IncidentsFacade incidents;

    @Autowired
    private NotificationApplicationService notificationApplicationService;


    @Test
    void incidentCreatedEventCausesNotification(Scenario scenario) {
        var fixture = new Incident(IncidentId.newId(),
                new Title("DNS resolution not possible"), Criticality.GTFO);
        when(incidents.getIncident(any())).thenReturn(Optional.of(fixture));

        scenario.publish(() -> new IncidentCreated(IncidentId.newId()))
                .andWaitAtMost(Duration.ofSeconds(2))
                .andWaitForStateChange(() -> notificationApplicationService.counter(), counter -> {
                    System.out.println(Instant.now() + " " + counter);
                    return counter != 0;
                })
                .andVerify(count -> assertThat(count).isEqualTo(1));
    }

}