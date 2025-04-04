package de.sebsprenger.incidentmgmt.communicate.secondary.log;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Entity(name = "incident_notification")
public class IncidentNotificationJpaDto {
    @Id
    int id;

    Instant timestamp;

    String message;

    @ElementCollection
    List<String> recipients;
}
