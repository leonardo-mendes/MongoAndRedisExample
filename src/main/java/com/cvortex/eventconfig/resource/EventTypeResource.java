package com.cvortex.eventconfig.resource;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventType;
import com.cvortex.eventconfig.service.ApplicationService;
import com.cvortex.eventconfig.service.EventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event-type")
@RequiredArgsConstructor
public class EventTypeResource {

    private final EventTypeService eventTypeService;

    @PostMapping
    public ResponseEntity<EventType> save(@RequestBody EventType eventType) {
        return ResponseEntity.ok(eventTypeService.insertEventType(eventType));
    }

    @GetMapping
    public ResponseEntity<Iterable<EventType>> findAll() {
        return ResponseEntity.ok(eventTypeService.findAll());
    }

}
