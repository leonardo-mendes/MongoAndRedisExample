package com.cvortex.eventconfig.resource;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventMetadata;
import com.cvortex.eventconfig.service.ApplicationService;
import com.cvortex.eventconfig.service.EventMetaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventMetaDataResource {

    private final EventMetaDataService eventMetaDataService;

    @PostMapping
    public ResponseEntity<EventMetadata> save(@RequestBody EventMetadata eventMetadata) {
        return ResponseEntity.ok(eventMetaDataService.insertEventType(eventMetadata));
    }

    @GetMapping
    public ResponseEntity<Iterable<EventMetadata>> findAll() {
        return ResponseEntity.ok(eventMetaDataService.findAll());
    }

}
