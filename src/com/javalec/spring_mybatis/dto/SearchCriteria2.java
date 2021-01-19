package com.javalec.spring_mybatis.dto;

public class SearchCriteria2 extends Criteria{
	private String foodkind;
	private String countrykind;
	private String timekind;
	private String[] foodList;
	private String[] countryList;
	private String[] timeList;
	

	
	public String getFoodkind() {
		return foodkind;
	}
	public void setFoodkind(String foodkind) {
		this.foodkind = foodkind;
	}
	public String getCountrykind() {
		return countrykind;
	}
	public void setCountrykind(String countrykind) {
		this.countrykind = countrykind;
	}
	public String getTimekind() {
		return timekind;
	}
	public void setTimekind(String timekind) {
		this.timekind = timekind;
	}
	public String[] getFoodList() {
		return foodList;
	}
	public void setFoodList(String[] foodList) {
		this.foodList = foodList;
	}
	public String[] getCountryList() {
		return countryList;
	}
	public void setCountryList(String[] countryList) {
		this.countryList = countryList;
	}
	public String[] getTimeList() {
		return timeList;
	}
	public void setTimeList(String[] timeList) {
		this.timeList = timeList;
	}


 

}