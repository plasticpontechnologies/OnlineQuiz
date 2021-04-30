package com.onlineexam.demo.Model;

import java.util.List;

public class Question {
	
	private int question_Id;
	private String question_name;
	List<option> options;
	public String getQuestion_name() {
		return question_name;
	}
	public void setQuestion_name(String question_name) {
		this.question_name = question_name;
	}
	public int getQuestion_Id() {
		return question_Id;
	}
	public void setQuestion_Id(int question_Id) {
		this.question_Id = question_Id;
	}
	
	
	public List<option> getOptions() {
		return options;
	}
	public void setOptions(List<option> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "Question [question_Id=" + question_Id + ", question_name=" + question_name + "]";
	}
}
