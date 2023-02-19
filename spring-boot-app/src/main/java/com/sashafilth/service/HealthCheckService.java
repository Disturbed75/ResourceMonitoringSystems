package com.sashafilth.service;

import com.sashafilth.dto.HealthCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.elasticsearch.ElasticsearchRestHealthIndicator;
import org.springframework.boot.actuate.mongo.MongoHealthIndicator;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    private final MongoHealthIndicator mongoHealthIndicator;
    private final ElasticsearchRestHealthIndicator elasticsearchRestHealthIndicator;

    @Autowired
    public HealthCheckService(
            MongoHealthIndicator mongoHealthIndicator,
            ElasticsearchRestHealthIndicator elasticsearchRestHealthIndicator
    ) {
        this.mongoHealthIndicator = mongoHealthIndicator;
        this.elasticsearchRestHealthIndicator = elasticsearchRestHealthIndicator;
    }

    public HealthCheckResponse healthCheck() {
        String mongoStatus = mongoHealthIndicator.getHealth(true).toString();
        String elasticStatus = elasticsearchRestHealthIndicator.getHealth(true).toString();
        return new HealthCheckResponse(mongoStatus, elasticStatus);
    }

}
