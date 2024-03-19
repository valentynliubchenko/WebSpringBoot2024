package com.valentyn;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class MyCustomIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Map<String, Object> map = new HashMap<>();
        map.put("MyMeasure", 123);
        return Health.up().withDetails(map).build();
    }
}
