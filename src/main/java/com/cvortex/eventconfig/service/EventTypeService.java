package com.cvortex.eventconfig.service;

import com.cvortex.eventconfig.domain.EventType;

public interface EventTypeService {

    EventType insertEventType(EventType eventType);

    Iterable<EventType> findAll();
}
