package com.zsga.ywpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 索引：用于指向各个页面
 * @author quadcopter
 *
 */
@Controller
@RequestMapping("indexing")
public class IndexingController {
	
	@RequestMapping("shouye")
	public String index() {
		return "shouye";
	}
	
	@RequestMapping("qdqt")
	public String qdqt() {
		return "qdqt";
	}
}
