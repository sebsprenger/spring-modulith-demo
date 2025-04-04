package de.sebsprenger.incidentmgmt.communicate.secondary.log;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "incidentlogs")
public class IncidentLogJpaDto {
    @Id
    UUID logId;

    UUID incidentId;

    @OneToMany
    List<IncidentNotificationJpaDto> notifications;
}
