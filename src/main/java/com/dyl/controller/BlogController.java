package com.dyl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@RequestMapping("/blogs")
	public String getBlogs() {
		
		return "blogs";
	}
}
