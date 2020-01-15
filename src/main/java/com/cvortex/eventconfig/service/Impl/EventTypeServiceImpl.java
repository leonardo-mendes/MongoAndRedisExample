package com.cvortex.eventconfig.service.Impl;

import com.cvortex.eventconfig.domain.EventType;
import com.cvortex.eventconfig.repository.EventTypeRepository;
import com.cvortex.eventconfig.service.EventTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventTypeServiceImpl implements EventTypeService {

    private final EventTypeRepository eventTypeRepository;

    @Override
    public EventType insertEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public Iterable<EventType> findAll() {
        return eventTypeRepository.findAll();
    }

}
