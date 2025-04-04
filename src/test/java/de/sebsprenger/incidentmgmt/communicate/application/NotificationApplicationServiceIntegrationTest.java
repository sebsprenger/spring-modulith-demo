package de.sebsprenger.incidentmgmt.communicate.application;

import de.sebsprenger.incidentmgmt.incidentresponse.IncidentsFacade;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Criticality;
import de.sebsprenger.incidentmgmt.incidentresponse.domain.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.time.Duration;
import java.time.Instant;

import static de.sebsprenger.incidentmgmt.TestConfig.POSTGRES_DOCKER_IMAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode.ALL_DEPENDENCIES;

@ApplicationModuleTest(ALL_DEPENDENCIES)
class NotificationApplicationServiceIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_DOCKER_IMAGE);

    @Autowired
    private IncidentsFacade incidents;

    @Autowired
    private NotificationApplicationService notificationApplicationService;


    @Test
    void newIncidentCausesNotification(Scenario scenario) {
        scenario.stimulate(() -> incidents.createIncident(new Title("testing title"), Criticality.MEDIUM))
                .andWaitAtMost(Duration.ofSeconds(2))
                .andWaitForStateChange(() -> notificationApplicationService.counter(), counter -> {
                    System.out.println(Instant.now() + " " + counter);
                    return counter != 0;
                })
                .andVerify(count -> assertThat(count).isEqualTo(1));
    }

}