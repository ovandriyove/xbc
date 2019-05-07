package xbc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("menu")
	public String menu() {
		return "menu";
	}

	@RequestMapping("biodata")
	public String biodata() {
		return "biodata";
	}
	
	@RequestMapping("trainer")
	public String trainer() {
		return "trainer";
	}
	
	@RequestMapping("batch")
	public String batch() {
		return "batch";
	}
	
	@RequestMapping("clazz")
	public String clazz() {
		return "clazz";
	}
}
