package com.joowon.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joowon.spring.test.ajax.domain.Url;
import com.joowon.spring.test.ajax.service.UrlService;

@Controller
@RequestMapping("/ajax/url")
public class urlController {
	
	@Autowired
	private UrlService urlService;
	
	@GetMapping("/create")
	public String createUrl() {
		
		return "ajax/url/create";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUrl(
			@RequestParam("name") String name
			, @RequestParam("link") String link) {
		
		Url url = new Url();
		url.setName(name);
		url.setLink(link);
		
		int count = urlService.addUrl(url);
		
		Map<String, String> resultMap = new HashMap<>();
		if (count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}

	@GetMapping("/list")
	public String urlList(Model model) {
		
		List<Url> urlList = urlService.selecturl();
		
		model.addAttribute("urlList", urlList);
		
		return "ajax/url/list";
	}
	
	
}
