package de.sebsprenger.simple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.modulith.Modulithic;
import org.springframework.modulith.core.ApplicationModules;

@Modulithic
@SpringBootApplication
public class SimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

    @Bean
    CommandLineRunner modulithVerifier() {
        return (String... args) -> {
            var modules = ApplicationModules.of(SimpleApplication.class);
            System.out.println(modules);

            modules.verify();
        };
    }
}
