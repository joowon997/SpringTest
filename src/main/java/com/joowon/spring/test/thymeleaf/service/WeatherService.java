package com.joowon.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joowon.spring.test.thymeleaf.domain.Weather;
import com.joowon.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> weatherList() {
		
		return weatherRepository.selectWeather();
	}

	public int addweather(Weather weather) {
		
		return weatherRepository.insertWeather(weather);
	}
}
