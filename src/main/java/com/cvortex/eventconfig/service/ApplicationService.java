package com.cvortex.eventconfig.service;

import com.cvortex.eventconfig.domain.Application;

public interface ApplicationService {

    Application insertApplication(Application application);

    Iterable<Application> findAll();
}
