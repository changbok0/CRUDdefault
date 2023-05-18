package com.example.mvc.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	
	private int boardSeq;
	private String title;
	private String contents;
	private Date regDate;
	
}
