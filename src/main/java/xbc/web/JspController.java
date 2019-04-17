package xbc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	
	@RequestMapping("menu")
	public String menu() {
		return "menu";
	}

	@RequestMapping("biodata")
	public String biodata() {
		return "biodata";
	}
}
