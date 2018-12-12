package cn.clj.zchao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
	
	public static void main(String[] args) throws ParseException {
		System.out.println(DateUtils.getToday());
		System.out.println(DateUtils.getYesterday());
		System.out.println(isTimeRange("15:00","5:00"));
	}
	public static int getYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	public static int getMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH)+1;
	}
	public static int getWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}
	
	public static int getDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	public static Date getYesterday(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}
	public static Date getTomorrow(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
	public static Date long2Date(Long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static Integer currentYear() {
		String format = "yyyy";
		return Integer.valueOf(formatDate2String(new Date(), format)).intValue();
	}
	
	/**
	 * yyyyMMdd
	 */
	public static String format2Date2(Date date) {
		String format = "yyyyMMdd";
		return formatDate2String(date, format);
	}
	
	/**
	 * yyyy-MM-dd
	 */
	public static String format2Date(Date date) {
		String format = "yyyy-MM-dd";
		return formatDate2String(date, format);
	}
	
	/**
	 * yyyy-MM-dd
	 */
	public static String format2Date(Date date,String format) {
		return formatDate2String(date, format);
	}
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String format2Datetime(Date date) {
		String format = "yyyy-MM-dd HH:mm:ss";
		return formatDate2String(date, format);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static String format2Datetimes(Date date) {
		String format = "yyyy-MM-dd HH:mm:ss.SSS";
		return formatDate2String(date, format);
	}

	public static String formatDate2String(Date date, String format) {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(date);
	}

	/**
	 * yyyy-MM-dd
	 */
	public static String getToday() {
		return format2Date(new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String getTodayTime() {
		return format2Datetime(new Date());
	}

	/**
	 * yyyyMMddHHmmss
	 */
	public static String getTimeNoSeparate() {
		return formatDate2String(new Date(), "yyyyMMddHHmmss");
	}

	private static Date parse(String date, String format) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.parse(date);
	}

	/**
	 * yyyy-MM-dd
	 */
	public static Date format(String str) {
		return formatString2Date(str, "yyyy-MM-dd");
	}

	public static Date formatString2Date(String str, String format) {
		Date result = null;
		try {
			result = parse(str, format);
		} catch (Exception ex) {
		}
		return result;
	}

	public static Date formatDate2Date(Date date, String format) {
		Date result = null;
		try {
			result = parse(formatDate2String(date, format), format);
		} catch (Exception ex) {
		}
		return result;
	}

	public static String getFirstDayOfMonth(int amount, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, amount);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate2String(c.getTime(), format);
	}

	public static Date getFirstDayOfMonth2Date(int amount, String format) {
		return format(getFirstDayOfMonth(amount, format));
	}

	public static Date getLastDayOfMonth2Date(int amount, String format) {
		return format(getLastDayOfMonth(amount, format));
	}

	public static String getLastDayOfMonth(int amount, String format) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, amount);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return formatDate2String(c.getTime(), format);
	}

	/**
	 * 天前天后
	 * @param date
	 * @param format
	 * @param amount
	 * @return
	 */
	public static String getDate2StringByDay(String date, String format, int amount) {
		return getDate2StringByDay(formatString2Date(date, format), format, amount);
	}

	/**
	 * 天前天后
	 * @param date
	 * @param format
	 * @param amount
	 * @return
	 */
	public static String getDate2StringByDay(Date date, String format, int amount) {
		return formatDate2String(getDateByDay(date, amount), format);
	}

	/**
	 * 月前时后
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getDateByMonth(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		return cal.getTime();
	}
	
	/**
	 * 天前天后
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getDateByDay(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * 时前时后
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getDateByHour(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR_OF_DAY, amount);
		return cal.getTime();
	}
	
	/**
	 * 分前分后
	 * @param date
	 * @param amount
	 * @return
	 */
	public static Date getDateByMinute(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, amount);
		return cal.getTime();
	}

	/**
	 * 当前日期的00:00:00.000
	 * @param date
	 * @return
	 */
	public static Date getDayByZero(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 一天的第几刻
	 * @param date
	 * @return
	 */
	public static int quarterOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int quarter = hour * 4 + minute / 15 - 1;
		return quarter;
	}

	/**
	 * 日期格式"yyyy-MM-dd"
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<String> getBetweenDate(String startDate, String endDate) {
        List<String> list = new ArrayList<String>();
        Date sd = formatString2Date(startDate, "yyyy-MM-dd");
        Date ed = formatString2Date(endDate, "yyyy-MM-dd");
		for (Date d = sd; d.before(getDateByDay(ed, 1)); d=getDateByDay(d, 1)) {
			list.add(format2Date(d));
		}
		return list;
	}
	/**
	 * 星期几
	 */
	public static int dayForWeek(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	/**
	 * 星期几
	 */
	public static int dayForWeek(String date){
		return dayForWeek(format(date));
	}
	
	/**
	 * 当前时间的小时
	 */
	public static int hourOfDay(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	
	/**
	 * 当前时间的小时
	 */
	public static int minuteOfHour(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int minute = cal.get(Calendar.MINUTE);
		return minute;
	}
	/**
	 * 当前时间  是否在时间范围内 （比对的是小时数）
	 * @return
	 */
	public static boolean isTimeRange(String startTime,String endTime){
		boolean b=false;
			Calendar cal = Calendar.getInstance();
			String[] startTimes=startTime.split(":");
			String[] endTimes=endTime.split(":");
			
			int nm = cal.get(Calendar.HOUR_OF_DAY)*60+cal.get(Calendar.MINUTE);
			int sm =0;
			int em =0;
			if(startTimes.length>1){
				sm=Integer.parseInt(startTimes[0])*60+Integer.parseInt(startTimes[1]);
			}else{
				sm=Integer.parseInt(startTimes[0])*60;
			}
			if(endTimes.length>1){
				em=Integer.parseInt(endTimes[0])*60+Integer.parseInt(endTimes[1]);
			}else{
				em = Integer.parseInt(endTimes[0])*60;
			}
			if(sm<nm && em>nm){
				b=true;
			}
			return b;
	}
	
	/**
	 * 查询本周第一天的时间 周一
	 * yyyy-MM-dd HH:mm:ss格式为：2017-03-06 00:00:00  
	 * @return
	 */
	public static Date getWeekStartDate(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		return date;
	}
	
	/**
	 * 查询本周第一天的时间 周一
	 * yyyy-MM-dd HH:mm:ss格式为：2017-03-06 00:00:00  
	 * @return
	 */
	public static Date getWeekStartDateChina(){
		Calendar cal = Calendar.getInstance(Locale.CHINA);
	    cal.setFirstDayOfWeek(Calendar.MONDAY);
	    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.SECOND,0);
	    cal.set(Calendar.MINUTE,0);
	    Date date = cal.getTime();
		return date;
	}
	/**
	 * 查询本月第一天的时间 本月一号
	 * yyyy-MM-dd HH:mm:ss格式为：2017-03-06 00:00:00  
	 * @return
	 */
	public static Date getMonthStartDate(){
		//获取前月的第一天
        Calendar cal_1=Calendar.getInstance();//获取当前日期
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        Date date = cal_1.getTime();
		return date;
	}
	
	/**
	 * 根据传入的时间  返回所在月的第一天  时分秒清零
	 * @param date
	 * @return
	 */
	public static Date getFirstDayByMonth(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 0);  
        cal.set(Calendar.DAY_OF_MONTH, 1); 
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date d = cal.getTime();
		return d;
	}
	
	/**
	 * 根据传入的时间  返回所在月的最后一天   时分秒清零
	 * @param date
	 * @return
	 */
	public static Date getLastDayByMonth(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);  
        cal.set(Calendar.DAY_OF_MONTH, 0);  
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        Date d = cal.getTime();
		return d;
	}
	
	/**
	 * 时分秒 最大   00:00:00
	 * @param date
	 * @return
	 */
	public static Date getTimeForMax(Date date){
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        Date d = cal.getTime();
		return d;
	}
}