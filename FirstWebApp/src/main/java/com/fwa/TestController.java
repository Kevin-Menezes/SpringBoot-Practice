package com.fwa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	// Go to index.jsp
	@RequestMapping("/")
	public String goToIndex() {

		return "index";
	}
	
	// Go to home.jsp
	@RequestMapping("/home")
	public String goToHome(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String uname = req.getParameter("name");
		session.setAttribute("name", uname);
		
		return "home";
	}

}
