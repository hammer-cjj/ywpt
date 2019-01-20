package com.zsga.ywpt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zsga.ywpt.dto.SignDto;
import com.zsga.ywpt.pojo.Sign;
import com.zsga.ywpt.pojo.User;
import com.zsga.ywpt.pojo.YearMonth;
import com.zsga.ywpt.service.SignService;
import com.zsga.ywpt.util.GotLocalIP;

@Controller
@RequestMapping("")
public class SignController {
	
	@Autowired
	private SignService signService;
	
	/**
	 * 将签到日期转换为前端可以接收的格式
	 * @param signList
	 * @return
	 */
	private List<SignDto> signDtoJson(List<Sign> signList) {
		List<SignDto> signDtoList = new ArrayList<SignDto>();
		//转换为前端可以接收的格式
		for (Sign s : signList) {
			SignDto sd = new SignDto();
			//获取年月日中的日
			Integer ss = Integer.parseInt(s.getSigndate().toString().substring(8, 10));
			sd.setSignDay(ss);
			signDtoList.add(sd);
		}
		return signDtoList;
	}
	
	/**
	 * 获取前一个月或后一个月签到日期
	 * @param request
	 * @return
	 */
	@RequestMapping("prevNextMonth")
	@ResponseBody
	public Map<String, Object> prevMonth(HttpServletRequest request,@RequestBody YearMonth yearMonth) {
		int year = 0, month = 0;
		int flag = yearMonth.getFlag();
		if (flag == -1) {  //上一个月
			year = Integer.parseInt(yearMonth.getYear());
			month = Integer.parseInt(yearMonth.getMonth()) - 1;
			if (month == 0) {
				month = 12;
				year -= 1;
			}
		} else if (flag == 1) { //下一个月
			year = Integer.parseInt(yearMonth.getYear());
			month = Integer.parseInt(yearMonth.getMonth()) + 1;
			if (month == 13) {
				month = 1;
				year += 1;
			}
		}
		
		String param = null; 
		if (month < 10) {
			param = year + "0" + month;
		} else {
			param = year + "" + month;
		}
		
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			User user = (User)request.getSession().getAttribute("user");
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("userid", user.getId());
			map.put("param", param);
			List<Sign> signList = signService.getPrevNextMonth(map);
			if (null != signList) {
				List<SignDto> signDtoList = signDtoJson(signList);
				modelMap.put("signList", signDtoList);
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}

	
	/**
	 * 获取当前月签到日期
	 * @param request
	 * @return
	 */
	@RequestMapping("currentMonth")
	@ResponseBody
	public Map<String, Object> currentMonth(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			User user = (User)request.getSession().getAttribute("user");
			List<Sign> signList = signService.getCurrentMonth(user.getId());
			if (null != signList) {
				List<SignDto> signDtoList = signDtoJson(signList);
				modelMap.put("signList", signDtoList);
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}

	/**
	 * 签到
	 * @param request
	 * @return
	 */
	@RequestMapping("sign")
	@ResponseBody
	public Map<String, Object> sign(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			Sign sign = new Sign();
			User user = (User)request.getSession().getAttribute("user");
			
			sign.setUserid(user.getId());
			sign.setSignip(GotLocalIP.getLocalIP());
			signService.sign(sign);
			
			List<Sign> signList = signService.getCurrentMonth(user.getId());
			if (null != signList) {
				List<SignDto> signDtoList = signDtoJson(signList);
				modelMap.put("signList", signDtoList);
			}
			
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
		}
		return modelMap;
	}
}
