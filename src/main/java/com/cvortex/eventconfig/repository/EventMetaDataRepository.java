package com.cvortex.eventconfig.repository;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.domain.EventMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventMetaDataRepository extends CrudRepository<EventMetadata, String> {
}
