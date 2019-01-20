package com.zsga.ywpt.pojo;

import java.util.Date;

public class Sign {
	private Integer id;
	private Integer userid;
	private String signip;
	private Date signdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getSignip() {
		return signip;
	}
	public void setSignip(String signip) {
		this.signip = signip;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	
}
