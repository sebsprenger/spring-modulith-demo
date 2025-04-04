package de.sebsprenger.incidentmgmt.util.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.EventPublication;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.modulith.events.core.EventPublicationRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventManagementJobs {

    private final EventPublicationRegistry registry;
    private final CompletedEventPublications completedEventPublications;
    private final IncompleteEventPublications incompleteEventPublications;

    @Scheduled(fixedDelayString = "1m")
    void retryJobs() {
        incompleteEventPublications.resubmitIncompletePublicationsOlderThan(Duration.ofSeconds(55));
        log.info("EYE-CATCHER: resubmitted failed events");
    }

    @Scheduled(fixedDelayString = "3m")
    void purgeCompletedEvents() {
        completedEventPublications.deletePublicationsOlderThan(Duration.ofMinutes(3));
        log.info("EYE-CATCHER: cleaned up completed events");
    }

    @Scheduled(fixedDelayString = "5s")
    void detectDeadLetters() {
        var deadLetterAmount = registry.findIncompletePublications().stream()
                .map(EventPublication::getPublicationDate)
                .filter(e -> e.isBefore(Instant.now().minus(Duration.ofSeconds(3))))
                .count();

        setGauge(deadLetterAmount);
    }

    private void setGauge(long deadLetterAmount) {
        log.info("EYE-CATCHER: amount of dead letter: {}", deadLetterAmount);
    }

}
