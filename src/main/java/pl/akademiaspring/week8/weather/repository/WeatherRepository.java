package pl.akademiaspring.week8.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week8.weather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
