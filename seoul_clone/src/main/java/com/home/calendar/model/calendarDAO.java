package com.home.calendar.model;

import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class calendarDAO {
	private calendarVO cal;

	public calendarVO getCal() {
		return cal;
	}
	public calendarDAO() {
		Date date = new Date();
		System.out.println(date.getYear());
		this.cal = new calendarVO(2020, date.getMonth()+1);
	}
	
}
