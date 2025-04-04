package de.sebsprenger.events.management.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.modulith.events.EventPublication;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Profile("managed")
@Component
@RequiredArgsConstructor
@Slf4j
public class UndocumentedEventManagement {

    private final EventPublicationRegistry registry;

    @Scheduled(fixedDelayString = "5s")
    void detectDeadLetters() {
        var threshold = Instant.now().minus(Duration.ofSeconds(3));
        var deadLetterAmount = registry.findIncompletePublications().stream()
                .map(EventPublication::getPublicationDate)
                .filter(creationTime -> creationTime.isBefore(threshold))
                .count();

        setGauge(deadLetterAmount);
    }

    private void setGauge(long deadLetterAmount) {
        log.info("EYE-CATCHER: amount of dead letter: {}", deadLetterAmount);
    }

}
