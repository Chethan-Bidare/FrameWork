package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import superBase.TestBase;

public class DateUtils extends TestBase{

	/**
     * get today's date
     *
     * @return - String - requested date as string
     */
	public static String getDateFullPatternAsString() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(cal.getTime());
	}
	
	/**
     * get a full pattern string of a date, by inputs of a selected date field and amount to control the selected field.
     *
     * @param amountOfDaysToChange   - the amount of time to be added to the field.
     *                 positive int "+" - get a date field in the future
     *                 negative int "-" - get a date field in the past
     * @return -  String - a full pattern string of a date
     */
	public static String getDateByChangingDays(int amountOfDaysToChange) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, amountOfDaysToChange);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(cal.getTime());
	}
	
	/**
     * get a full pattern string of a date, by inputs of a selected date field and amount to control the selected field.
     *
     * @param amountOfmonthstoChange   - the amount of Months to be added to the field.
     *                 positive int "+" - get a Month field in the future
     *                 negative int "-" - get a Month field in the past
     * @return -  String - a full pattern string of a date
     */
	public static String getDateByChangingMonths(int amountOfmonthsToChange) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, amountOfmonthsToChange);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(cal.getTime());
	}
	
	/**
     * get a full pattern string of a date, by inputs of a selected date field and amount to control the selected field.
     *
     * @param amountOfmonthstoChange   - the amount of Years to be added to the field.
     *                 positive int "+" - get a Years field in the future
     *                 negative int "-" - get a Years field in the past
     * @return -  String - a full pattern string of a date
     */
	public static String getDateByChangingYears(int amountOfYearsToChange) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.YEAR, amountOfYearsToChange);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(cal.getTime());
	}
	
	public static String getTimeAsString() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(cal.getTime());
	}
	
	
	
	
	
	
	
	
	
}
