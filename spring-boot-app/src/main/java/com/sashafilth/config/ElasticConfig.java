package com.sashafilth.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.elasticsearch.ElasticsearchRestHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;


@Configuration
public class ElasticConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;


    @Bean
    public RestHighLevelClient elasticsearchClient() {
        String connectionString = host + ":" + port;
        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo(connectionString)
                        .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchRestHealthIndicator elasticsearchHealthIndicator() {
        return new ElasticsearchRestHealthIndicator(elasticsearchClient());
    }

}
