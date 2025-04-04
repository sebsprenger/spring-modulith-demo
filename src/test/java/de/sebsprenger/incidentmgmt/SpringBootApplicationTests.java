package de.sebsprenger.incidentmgmt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.modulith.core.ApplicationModules;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static de.sebsprenger.incidentmgmt.TestConfig.POSTGRES_DOCKER_IMAGE;

@SpringBootTest
class SpringBootApplicationTests {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(POSTGRES_DOCKER_IMAGE);

    @Test
    void contextLoads() {
        var modules = ApplicationModules.of(IncidentApplication.class);
        System.out.println(modules);

        modules.verify();
    }

}
