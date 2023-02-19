package com.sashafilth.dto;

public class HealthCheckResponse {

    private String mongoStatus;
    private String elasticStatus;

    public HealthCheckResponse() {
    }

    public HealthCheckResponse(String mongoStatus, String elasticStatus) {
        this.mongoStatus = mongoStatus;
        this.elasticStatus = elasticStatus;
    }

    public String getMongoStatus() {
        return mongoStatus;
    }

    public void setMongoStatus(String mongoStatus) {
        this.mongoStatus = mongoStatus;
    }

    public String getElasticStatus() {
        return elasticStatus;
    }

    public void setElasticStatus(String elasticStatus) {
        this.elasticStatus = elasticStatus;
    }
}
