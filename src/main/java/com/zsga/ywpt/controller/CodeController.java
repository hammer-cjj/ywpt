package com.zsga.ywpt.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 产生4位验证码
 * @author quadcopter
 *
 */
@Controller
public class CodeController {
	@SuppressWarnings("finally")
	@RequestMapping("/verifyCode")
	@ResponseBody
	public Map<String, Object> generate4Code() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7",
					"8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
					"W", "X", "Y", "Z" };
			List<String> list = Arrays.asList(beforeShuffle);
			Collections.shuffle(list);
			StringBuffer sb = new StringBuffer();
			for (int i=0; i<list.size(); i++) {
				sb.append(list.get(i));
			}
			String afterShuffle = sb.toString();
			String result = afterShuffle.substring(5, 9);
			modelMap.put("verifyCodeExpected", result);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errVerifyCode", "验证码产生错误");
		} finally {
			return modelMap;
		}
		
	}
}
