package pl.akademiaspring.week8.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.akademiaspring.week8.weather.service.api.WeatherApiObject;
import pl.akademiaspring.week8.weather.model.Weather;
import pl.akademiaspring.week8.weather.repository.WeatherRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {

    private WeatherRepository weatherRepository;
    private List<String> listCities = Arrays.asList("Warsaw", "London", "Paris", "Moscow");
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private int index = 0;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    private WeatherApiObject getCityWheather() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherApiObject exchangeRates =
                restTemplate.getForObject("http://api.weatherstack.com/current?access_key=3381831599b840c773d1ac161a48e6a4&query="
                                + listCities.get(index++),
                WeatherApiObject.class);

        if (index == listCities.size()) index = 0;

        return exchangeRates;
    }

    @Scheduled(fixedDelay = 3600000) //hour
    public void getApiWeather() {
        WeatherApiObject weatherApiObject = getCityWheather();

        weatherRepository.save(new Weather(
                weatherApiObject.getLocation().getName(),
                weatherApiObject.getLocation().getCountry(),
                LocalDateTime.parse(weatherApiObject.getLocation().getLocaltime(), formatter),
                weatherApiObject.getCurrent().getTemperature(),
                weatherApiObject.getCurrent().getWeatherDescriptions().get(0),
                weatherApiObject.getCurrent().getWindSpeed(),
                weatherApiObject.getCurrent().getWindDir(),
                weatherApiObject.getCurrent().getPressure(),
                weatherApiObject.getCurrent().getHumidity(),
                weatherApiObject.getCurrent().getCloudcover(),
                weatherApiObject.getCurrent().getFeelslike(),
                weatherApiObject.getCurrent().getUvIndex(),
                weatherApiObject.getCurrent().getIsDay().equalsIgnoreCase("yes") ? true : false
        ));
    }
}
