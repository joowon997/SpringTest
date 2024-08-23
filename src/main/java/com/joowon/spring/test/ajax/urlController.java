package com.joowon.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//view
	@GetMapping("/list")
	public String urlList(Model model) {
		
		List<Url> urlList = urlService.selecturl();
		
		model.addAttribute("urlList", urlList);
		
		return "ajax/url/list";
	}
	
	@GetMapping("/create")
	public String createUrl() {
		
		return "ajax/url/create";
	}
	
	//API 
	@PostMapping("/add")
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

	// 중복검사
	@PostMapping("/duplicate-url")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(
			@RequestParam("url") String url){
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if (urlService.isDuplicateUrl(url)) {
			resultMap.put("isDuplicate", true);
		}else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
	}
	
	// 삭제기능
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, Boolean> deleteUrl(
			@RequestParam("id") int id) {
		
		Map<String, Boolean> deleteMap = new HashMap<>();
		
		if (urlService.deleteUrl(id)) {
			deleteMap.put("isDelete", true);
		}else {
			deleteMap.put("isDelete", false);
		}
		return deleteMap;
	}
	
	
}
