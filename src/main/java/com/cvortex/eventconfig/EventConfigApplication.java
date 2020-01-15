package com.cvortex.eventconfig;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventMetadata;
import com.cvortex.eventconfig.domain.EventType;
import com.cvortex.eventconfig.domain.loadAppDomain.LoadApplication;
import com.cvortex.eventconfig.service.ApplicationService;
import com.cvortex.eventconfig.service.EventMetaDataService;
import com.cvortex.eventconfig.service.EventTypeService;
import com.cvortex.eventconfig.service.LoadApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@RequiredArgsConstructor
public class EventConfigApplication implements CommandLineRunner {

    private final ApplicationService applicationService;
    private final EventTypeService eventTypeService;
    private final EventMetaDataService eventMetaDataService;
    private final LoadApplicationService loadApplicationService;

    public static void main(String[] args) {
        SpringApplication.run(EventConfigApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Application firstApplication = applicationService.insertApplication(
                Application.builder()
                        .name("firstApplication")
                        .build()
        );

        Application secondApplication = applicationService.insertApplication(
                Application.builder()
                        .name("secondApplication")
                        .build()
        );

        EventType firstEventType = eventTypeService.insertEventType(
                EventType.builder()
                        .name("firstEventType")
                        .build()
        );

        EventType secondEventType = eventTypeService.insertEventType(
                EventType.builder()
                        .name("secondEventType")
                        .build()
        );

        EventMetadata firstEventMetadata = eventMetaDataService.insertEventType(
                EventMetadata.builder()
                        .name("firstEvent")
                        .eventType(firstEventType.getId().toHexString())
                        .applications(Arrays.asList(firstApplication, secondApplication))
                        .build()
        );

        EventMetadata secondEventMetadata = eventMetaDataService.insertEventType(
                EventMetadata.builder()
                        .name("secondEvent")
                        .eventType(secondEventType.getId().toHexString())
                        .applications(Arrays.asList(firstApplication))
                        .build()
        );

        firstEventType.setEventMetadata(Arrays.asList(firstEventMetadata));
        secondEventType.setEventMetadata(Arrays.asList(firstEventMetadata, secondEventMetadata));
        eventTypeService.insertEventType(firstEventType);
        eventTypeService.insertEventType(secondEventType);

        loadApplicationService.insertConfiguration(
                LoadApplication.builder()
                        .application(firstApplication)
                        .eventTypes(Arrays.asList(firstEventType, secondEventType))
                        .build()
        );

        loadApplicationService.insertConfiguration(
                LoadApplication.builder()
                        .application(secondApplication)
                        .eventTypes(Arrays.asList(firstEventType, secondEventType))
                        .build()
        );

    }
}
