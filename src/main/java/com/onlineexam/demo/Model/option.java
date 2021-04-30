package com.onlineexam.demo.Model;

public class option {

	
	public int option_Id;
	public String option_name;
	public int question_Id;
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public int getOption_Id() {
		return option_Id;
	}
	public void setOption_Id(int option_Id) {
		this.option_Id = option_Id;
	}
	public int getQuestion_Id() {
		return question_Id;
	}
	public void setQuestion_Id(int question_Id) {
		this.question_Id = question_Id;
	}
	@Override
	public String toString() {
		return "Options [option_Id=" + option_Id + ", option_name=" + option_name + ", question_Id=" + question_Id
				+ "]";
	}

	
}
