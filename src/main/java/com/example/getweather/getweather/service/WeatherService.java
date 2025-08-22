package com.example.getweather.getweather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {


    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestClient restClient;

    public WeatherService(RestClient restClient) {
        this.restClient = restClient;
    }

    public Map<String, Object> getWeather(String cityInput) {
        // If user didn’t specify country code, default to India
        String cityQuery = cityInput.contains(",") ? cityInput : cityInput + ",IN";

        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("q", cityQuery)
                            .queryParam("appid", apiKey)
                            .queryParam("units", "metric")
                            .build())
                    .retrieve()
                    .body(Map.class);

        } catch (RestClientException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            if (e.getMessage().contains("401")) {
                errorResponse.put("error", "Invalid or inactive API key. Please try again later.");
            } else if (e.getMessage().contains("404")) {
                errorResponse.put("error", "City not found. Please check the city name.");
            } else {
                errorResponse.put("error", "Weather service is currently unavailable. Please try later.");
            }
            return errorResponse;
        }
    }
}

