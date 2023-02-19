package com.sashafilth.controller;

import com.sashafilth.dto.HealthCheckResponse;
import com.sashafilth.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/health-check")
public class HealthCheckController {

    private final HealthCheckService healthCheckService;

    @Autowired
    public HealthCheckController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping
    public ResponseEntity<HealthCheckResponse> healthCheck() {
        HealthCheckResponse response = healthCheckService.healthCheck();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
