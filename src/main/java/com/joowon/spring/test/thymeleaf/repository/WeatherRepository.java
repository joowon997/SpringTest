package com.joowon.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joowon.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeather();
	
	public int insertWeather(Weather weather);
}
