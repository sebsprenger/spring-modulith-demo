package de.sebsprenger.incidentmgmt.user.domain;

public record User(
        UserId id,
        Username username,
        Firstname firstname,
        Lastname lastname
) {
}
