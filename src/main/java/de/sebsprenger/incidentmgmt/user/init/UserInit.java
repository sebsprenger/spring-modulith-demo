package de.sebsprenger.incidentmgmt.user.init;

import de.sebsprenger.incidentmgmt.user.secondary.UserJpaDto;
import de.sebsprenger.incidentmgmt.user.secondary.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInit implements ApplicationModuleInitializer {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void initialize() {
        userJpaRepository.save(UserJpaDto.builder().username("seb").firstname("Sebastian").lastname("Sprenger").build());
    }
}
