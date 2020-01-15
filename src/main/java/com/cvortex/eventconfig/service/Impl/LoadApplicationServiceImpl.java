package com.cvortex.eventconfig.service.Impl;

import com.cvortex.eventconfig.domain.loadAppDomain.LoadApplication;
import com.cvortex.eventconfig.repository.redis.RedisRepository;
import com.cvortex.eventconfig.service.LoadApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoadApplicationServiceImpl implements LoadApplicationService {

    private static final String HASH_REDIS = "loadConfiguration";

    private final RedisRepository<LoadApplication> redisCacheService;

    @Override
    public Optional<LoadApplication> getConfigurations(String applicationId) {
        return redisCacheService.get(HASH_REDIS, applicationId);
    }

    @Override
    public void insertConfiguration(LoadApplication loadApplication) {
        redisCacheService.save(HASH_REDIS, loadApplication.getApplication().getId().toString(), loadApplication);
    }
}
