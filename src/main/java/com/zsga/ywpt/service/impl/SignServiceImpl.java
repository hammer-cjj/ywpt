package com.zsga.ywpt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsga.ywpt.mapper.SignMapper;
import com.zsga.ywpt.pojo.Sign;
import com.zsga.ywpt.service.SignService;

@Service
public class SignServiceImpl implements SignService {
	
	@Autowired
	private SignMapper signMapper;

	@Override
	public void sign(Sign sign) {
		signMapper.sign(sign);
	}

	@Override
	public List<Sign> getCurrentMonth(Integer userid) {
		return signMapper.getCurrentMonth(userid);
	}

	@Override
	public List<Sign> getPrevNextMonth(Map<String, Object> map) {
		return signMapper.getPrevNextMonth(map);
	}

}
