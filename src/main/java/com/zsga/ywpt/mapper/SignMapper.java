package com.zsga.ywpt.mapper;

import java.util.List;
import java.util.Map;

import com.zsga.ywpt.pojo.Sign;

public interface SignMapper {
	void sign(Sign sign);
	//获取当前月的签到
	List<Sign> getCurrentMonth(Integer userid);
	//获取前一个月的签到
	List<Sign> getPrevNextMonth(Map<String, Object> map);
}
