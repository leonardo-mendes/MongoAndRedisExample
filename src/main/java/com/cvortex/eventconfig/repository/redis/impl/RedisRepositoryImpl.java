package com.cvortex.eventconfig.repository.redis.impl;

import com.cvortex.eventconfig.repository.redis.RedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl<T> implements RedisRepository<T> {

    private final RedisTemplate<String, T> redisTemplate;

    private HashOperations<String, String, T> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String hashName, String key, T item) {
        try {
            hashOperations.put(hashName, StringUtils.capitalize(key), item);
        }
        catch (Exception ex) {
            log.error("Ocorreu um erro ao consultar o Redis", ex);
        }
    }

    @Override
    public Optional<T> get(String hashName, String key) {
        try {
            return Optional.ofNullable(hashOperations.get(hashName, StringUtils.capitalize(key)));
        }
        catch (Exception ex) {
            log.error("Ocorreu um erro ao consultar o Redis", ex);
            return Optional.empty();
        }
    }

}