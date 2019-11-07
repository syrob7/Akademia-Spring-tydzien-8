package pl.akademiaspring.week8.weather.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "weathers")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String country;
    private LocalDateTime date;
    private int temperature;
    private String description;
    private int windSpeed;
    private String windDir;
    private int pressure;
    private int humidity;
    private int cloudcover;
    private int feelslike;
    private int uvIndex;
    private Boolean isDay;

    public Weather() {
    }

    public Weather(String city, String country, LocalDateTime date, int temperature, String description,
                   int windSpeed, String windDir, int pressure, int humidity, int cloudcover,
                   int feelslike, int uvIndex, Boolean isDay) {

        this.city = city;
        this.country = country;
        this.date = date;
        this.temperature = temperature;
        this.description = description;
        this.windSpeed = windSpeed;
        this.windDir = windDir;
        this.pressure = pressure;
        this.humidity = humidity;
        this.cloudcover = cloudcover;
        this.feelslike = feelslike;
        this.uvIndex = uvIndex;
        this.isDay = isDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(int cloudcover) {
        this.cloudcover = cloudcover;
    }

    public int getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(int feelslike) {
        this.feelslike = feelslike;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(int uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Boolean isDay() {
        return isDay;
    }

    public void setDay(Boolean day) {
        isDay = day;
    }
}
