package kr.ac.jejuuniv.twitter.service;

import java.util.Calendar;

public class CheckToday {
	public String Today(){
		Calendar t = Calendar.getInstance();
		String year = Integer.toString(t.get(Calendar.YEAR));
		String month = Integer.toString(t.get(Calendar.MONTH)+1);
		
		String day = Integer.toString(t.get(Calendar.DAY_OF_MONTH));
		String hh = Integer.toString(t.get(Calendar.HOUR_OF_DAY));
		String mm = Integer.toString(t.get(Calendar.MINUTE));
		String ss = Integer.toString(t.get(Calendar.SECOND));
		String today = year + "-" + month+"-"+day+" "+hh+":"+mm+":"+ss;
		
		return today;
	}
}