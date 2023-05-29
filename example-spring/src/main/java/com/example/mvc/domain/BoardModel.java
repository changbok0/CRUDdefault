package com.example.mvc.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardModel {
	
	private int boardSeq;
	private String title;
	private String contents;
	private Date regDate;
	
}
