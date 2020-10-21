package com.home.calendar.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class monthVO {
	
	private int month;
	private ArrayList<dateVO> dates =new ArrayList<dateVO>();
	
}
