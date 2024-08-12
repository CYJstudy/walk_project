package com.walk.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {

	@GetMapping("/main-list-view")
	public String main() {
		
		return "main/mainList";
	}
}
