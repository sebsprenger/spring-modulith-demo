# spring-modulith-demo
Trying out [Spring Modulith](https://docs.spring.io/spring-modulith/reference/index.html) in the context of an incident management application

There are three mini-applications which can be used explore some aspects of Spring Modulith.

## SimpleApplication
Main class: `de.sebsprenger.simple.SimpleApplication`

Just two modules to get started. The main applications creates a command line runner to verify the module structure.

## EventApplication
Main class: `de.sebsprenger.simple.EventApplication`

A controller emits an event which is consumed by two listeners. One of the listeners periodically fails. When the 
application is started with the profile `managed` one can restart the processing of the event via a controller (find
the id in the database) or wait for the job to retrigger the event.

Also notice the two config settings in `application.properties`:
```properties
spring.modulith.events.completion-mode=archive
spring.modulith.events.republish-outstanding-events-on-restart=false
```

## IncidentApplication
Main class: `de.sebsprenger.simple.IncidentApplication`

A slightly more complex application with several modules and the IncidentCreated event. There also tests to demonstrate
the PublishedEvents and Scenario utilities.