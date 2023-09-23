package com.weatherapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(@RequestParam String location) {
        // Replace 'YOUR_API_KEY' with your OpenWeatherMap API key
        String apiKey = "ac4b61ed7c9430ed6e18f06f3fc76b3d";
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&units=metric&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String weatherData = restTemplate.getForObject(apiUrl, String.class);

        return weatherData;
    }
}
