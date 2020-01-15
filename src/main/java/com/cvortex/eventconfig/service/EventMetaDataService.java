package com.cvortex.eventconfig.service;

import com.cvortex.eventconfig.domain.EventMetadata;
import com.cvortex.eventconfig.domain.EventType;

public interface EventMetaDataService {

    EventMetadata insertEventType(EventMetadata eventMetadata);

    Iterable<EventMetadata> findAll();
}
