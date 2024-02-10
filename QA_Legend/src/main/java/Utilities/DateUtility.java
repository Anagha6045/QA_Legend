package Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateUtility
{
	
	public static String getCurrentDate()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		String formatedDate = sdf.format(date);
		return formatedDate;
	}
	public static String getCurrenttime() {
		Date date = new Date();
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm:aa");
		String formatedTime = stf.format(date);
		return formatedTime;
		
		
	}
	public static LocalDate getTommarowDate()
	{
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		return tomorrow;
	}
}
