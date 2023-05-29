package com.example.mvc.parameter;

import java.util.Date;

import lombok.Data;

@Data
public class StateGetDto {
	
	private String title;
	private String contents;
	private int cuid;
	private Date regDate;
	private String firstState;
	private String secondState;
	private String thirdState;
}
