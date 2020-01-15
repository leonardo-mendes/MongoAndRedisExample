package com.cvortex.eventconfig.repository;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, String> {
}
