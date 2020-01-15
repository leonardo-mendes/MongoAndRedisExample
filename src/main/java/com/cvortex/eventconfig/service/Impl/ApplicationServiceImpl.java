package com.cvortex.eventconfig.service.Impl;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.repository.ApplicationRepository;
import com.cvortex.eventconfig.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Application insertApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public Iterable<Application> findAll() {
        return applicationRepository.findAll();
    }

}

