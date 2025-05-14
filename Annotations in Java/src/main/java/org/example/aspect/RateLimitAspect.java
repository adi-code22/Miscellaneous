package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.model.RateLimit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimitAspect {

    private final Map<String, List<Long>> requestTimes = new ConcurrentHashMap<>();

    @Around("@annotation(rateLimit)")
    public Object rateLimitHandler(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {
        String key = joinPoint.getSignature().toShortString();
        int limit = rateLimit.limit();
        long now = System.currentTimeMillis();

        requestTimes.putIfAbsent(key, new ArrayList<>());
        List<Long> timestamps = requestTimes.get(key);

        // Keep only recent timestamps (last 60 seconds)
        timestamps.removeIf(time -> now - time > 60_000);

        if (timestamps.size() >= limit) {
            throw new RuntimeException("Rate limit exceeded for method: " + key);
        }

        timestamps.add(now);
        return joinPoint.proceed();
    }
}
