package com.home.main.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class mainVO {
	
	private String id;
	private String pwd;
	private long login_count;
	private LocalDate login_date;
	private LocalDate last_login_date;
}
