package com.cvortex.eventconfig.repository.redis;

import java.util.Optional;

public interface RedisRepository<T> {

    void save(String hashName, String key, T item);

    Optional<T> get(String hashName, String key);

}