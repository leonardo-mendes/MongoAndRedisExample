package com.cvortex.eventconfig.service.Impl;

import com.cvortex.eventconfig.domain.EventMetadata;
import com.cvortex.eventconfig.domain.EventType;
import com.cvortex.eventconfig.repository.EventMetaDataRepository;
import com.cvortex.eventconfig.repository.EventTypeRepository;
import com.cvortex.eventconfig.service.EventMetaDataService;
import com.cvortex.eventconfig.service.EventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventMetaDataServiceImpl implements EventMetaDataService {

    private final EventMetaDataRepository eventMetaDataRepository;

    @Override
    public EventMetadata insertEventType(EventMetadata eventMetadata) {
        return eventMetaDataRepository.save(eventMetadata);
    }

    @Override
    public Iterable<EventMetadata> findAll() {
        return eventMetaDataRepository.findAll();
    }
}
