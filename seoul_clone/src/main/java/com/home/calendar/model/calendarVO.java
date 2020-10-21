package com.home.calendar.model;

import java.util.ArrayList;
import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class calendarVO {

	private int year;
	private ArrayList<monthVO> months =new ArrayList<monthVO>();
	private int curmonth;
	
	public calendarVO getInstacne() {
		for(int i =1; i<curmonth; i++) {
			monthVO temp = months.get(0);
			months.remove(0);
			months.add(temp);
		}
		return this;
	}
	public calendarVO(int year, int curmonth) {
		this.curmonth =curmonth;
		Calendar cld = Calendar.getInstance();
		cld.set(cld.YEAR, year);
		this.setYear(cld.get(cld.YEAR));
		
		for(int i=0;i<cld.getMaximum(cld.MONTH)+1;i++) {
			monthVO monthvo = new monthVO();
			monthvo.setMonth(i+1);
			cld.set(cld.MONTH, monthvo.getMonth()-1);
			for(int j =0; j<cld.getActualMaximum(cld.DATE); j++) {
				dateVO date = new dateVO();
				date.setDate(j+1);
				cld.set(cld.DATE, date.getDate());
				int day = cld.get(cld.DAY_OF_WEEK);
				switch(day) {
					case 1:{
						date.setDay("일");
						break;
					}
					case 2:{
						date.setDay("월");
						break;
					}
					case 3:{
						date.setDay("화");
						break;
					}
					case 4:{
						date.setDay("수");
						break;
					}
					case 5:{
						date.setDay("목");
						break;
					}
					case 6:{
						date.setDay("금");
					}
					case 7:{
						date.setDay("토");
					}
				}
				monthvo.getDates().add(date);
			};
			this.getMonths().add(monthvo);	
		}
	}
}
