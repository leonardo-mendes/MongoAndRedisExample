package com.cvortex.eventconfig.service;

import com.cvortex.eventconfig.domain.loadAppDomain.LoadApplication;

import java.util.Optional;

public interface LoadApplicationService {

    Optional<LoadApplication> getConfigurations(String applicationId);

    void insertConfiguration(LoadApplication loadApplication);
}
