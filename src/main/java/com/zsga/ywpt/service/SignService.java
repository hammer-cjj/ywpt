package com.zsga.ywpt.service;

import java.util.List;
import java.util.Map;

import com.zsga.ywpt.pojo.Sign;

public interface SignService {
	void sign(Sign sign);
	
	List<Sign> getCurrentMonth(Integer userid);
	
	List<Sign> getPrevNextMonth(Map<String, Object> map);
	
}
