package de.sebsprenger.incidentmgmt.user.secondary;


import de.sebsprenger.incidentmgmt.user.domain.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserJpaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String firstname;
    private String lastname;

    static User toDomain(UserJpaDto dto) {
        return new User(
                new UserId(dto.id()),
                new Username(dto.username()),
                new Firstname(dto.firstname()),
                new Lastname(dto.lastname())
        );
    }
}