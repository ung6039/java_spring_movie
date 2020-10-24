package com.home.calendar.model;

import java.util.Calendar;

public class calendar1 {
	
	public void calendar() {
		Calendar cal = Calendar.getInstance();
		int day[][][] = new int[12][6][7];
		String week[] = new String[] {
				"일","월","화","수","목","금","토"
		};
		
		for(int month=0;month<12;month++) {
			cal.set(Calendar.MONTH, month);
			//이번달 마직막일 maxDay에 저장
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			
			for(int i =1;i<=maxDay;i++) {
				cal.set(Calendar.DATE, i);
				
				day[cal.get(Calendar.MONTH)]
						[cal.get(Calendar.WEEK_OF_MONTH)-1]
								[cal.get(Calendar.DAY_OF_WEEK)-1] = i;
			}
		}
		
		for(int month=0;month<12;month++) {
			int mm = month+1;
			System.out.println(" "+mm+"월");
			for(int i=0;i<week.length;i++) {
				System.out.print(week[i]+" ");
			}
		System.out.println();
			for(int i =0;i<6;i++) {
				for(int j =0;j<7;j++) {
					if(day[month][i][j] !=0) {
						System.out.print(day[month][i][j]+" ");
					}else {
						System.out.println(" ");
					}
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		calendar1 cal = new calendar1();
		cal.calendar();
	}
}
