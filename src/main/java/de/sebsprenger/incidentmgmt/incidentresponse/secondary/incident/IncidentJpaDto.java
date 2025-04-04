package de.sebsprenger.incidentmgmt.incidentresponse.secondary.incident;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "incidents")
public class IncidentJpaDto {
        @Id
        private UUID uuid;
        private String name;
        private String criticality;
}
