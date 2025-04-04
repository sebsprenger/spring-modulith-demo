package de.sebsprenger.events.management.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

@Profile("managed")
@RestController
@RequiredArgsConstructor
@Slf4j
public class DocumentedEventMangement {

    private final CompletedEventPublications completedEventPublications;
    private final IncompleteEventPublications incompleteEventPublications;

    @Scheduled(fixedDelayString = "5m")
    void purgeCompletedEvents() {
        completedEventPublications.deletePublicationsOlderThan(Duration.ofMinutes(3));
        log.info("EYE-CATCHER: cleaned up completed events");
    }

    @Scheduled(fixedDelayString = "3m")
    void retryEvents() {
        incompleteEventPublications.resubmitIncompletePublicationsOlderThan(Duration.ofSeconds(10));
        log.info("EYE-CATCHER: resubmitted failed events");
    }

    @PostMapping("/events/{id}")
    void retrigger(@PathVariable UUID id) {
        incompleteEventPublications.resubmitIncompletePublications(event -> event.getIdentifier().equals(id));
    }

}
