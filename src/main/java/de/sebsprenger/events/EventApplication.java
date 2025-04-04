package de.sebsprenger.events;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.core.ApplicationModules;

@Modulithic
@SpringBootApplication
public class EventApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventApplication.class, args);
    }

    @Bean
    CommandLineRunner modulithVerifier() {
        return (String... args) -> {
            var modules = ApplicationModules.of(EventApplication.class);
            System.out.println(modules);

            modules.verify();
        };
    }
}
