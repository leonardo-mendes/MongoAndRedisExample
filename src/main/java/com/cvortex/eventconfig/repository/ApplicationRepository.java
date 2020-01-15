package com.cvortex.eventconfig.repository;

import com.cvortex.eventconfig.domain.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, String> {
}
