package com.joowon.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01Controller {

	@RequestMapping("/1")
	public String welcome() {
		
		return "<h1>테스트 프로젝트 완성</h1><h4>해당 프로젝트를 통해서 문제를 풀어 봅시다.</h4>";
	}
	
	@RequestMapping("/2")
	public Map<String, Integer> score(){
		Map<String, Integer> score = new HashMap<>();
		
		score.put("국어", 80);
		score.put("수학", 90);
		score.put("영어", 85);
		
		return score;
	}
}
