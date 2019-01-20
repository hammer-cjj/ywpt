package com.zsga.ywpt.pojo;

public class YearMonth {
	private String year;
	private String month;
	private Integer flag; //1:下一个月;-1:上一个月
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
