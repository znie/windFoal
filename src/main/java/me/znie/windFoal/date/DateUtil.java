package me.znie.windFoal.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 现成安全的DateFormat
 * @author znie
 *
 */
public class DateUtil {

	//精确到毫秒的数据
	public static final String DATE_PATTERN_MILL = "yyyyMMddHHmmssSSS";
	
	public static final String DATE_PATTERN_ALL2 = "yyyyMMddHHmmss";

	public static final String DATE_PATTERN_ALL = "yyyy-MM-dd HH:mm:ss";

	public static final String DATE_PATTERN_NORMAL = "yyyy-MM-dd";

	public static final String DATE_PATTERN_NORMAL2 = "yyyyMMdd";

	//线程安全
	private static ThreadLocal<Map<String,SimpleDateFormat>> threadLocal = new ThreadLocal<Map<String,SimpleDateFormat>>();
	
	public static SimpleDateFormat getSimpleDateFormat(String pattern){
		return getSimpleDateFormat(pattern, Locale.getDefault());
	}
	
	public static SimpleDateFormat getSimpleDateFormat(String pattern,Locale locale){
		Map<String,SimpleDateFormat> formatMap = threadLocal.get();
		SimpleDateFormat format = null;
//		System.out.println(Thread.currentThread().getName()+formatMap);
		if(formatMap == null){
			formatMap = new HashMap<String,SimpleDateFormat>();
			format = new SimpleDateFormat(pattern,locale);
			formatMap.put(pattern, format);
			threadLocal.set(formatMap);
		}else{
			format = formatMap.get(pattern);
			if(format==null){
				format = new SimpleDateFormat(pattern,locale);
				formatMap.put(pattern, format);
			}
		}
		return format;
	}
	
	public static Date parse(String parttern, String str) throws ParseException{
		return getSimpleDateFormat(parttern).parse(str);
	}
	
	public static String format(String parttern, Date date) throws ParseException{
		return getSimpleDateFormat(parttern).format(date);
	}

	/**
	 * 半小时后
	 * @param date
	 * @return
	 */
	public static Date getHalfHour(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, 30);
		return calendar.getTime();
	}

	/**
	 * 当前年份
	 * @return
	 */
	public static Integer getCurYear(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	/**
	 * 当前月份
	 * @return
	 */
	public static Integer getCurMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.MONTH)+1;
	}

	/**
	 * 获取当前时间的前后几天，并返回yyyyMMdd
	 */
	public static String getEvDay(int evDay) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, evDay);
		return getSimpleDateFormat(DATE_PATTERN_NORMAL2).format(calendar.getTime());
	}
	
	public static void main(String[] args) throws ParseException{
		System.out.println(parse(DATE_PATTERN_MILL, "20180912110220333"));
		System.out.println(format(DATE_PATTERN_NORMAL, new Date()));
		System.out.println(getCurMonth());
		System.out.println(getEvDay(-2));
		System.out.println(DateUtil.parse(DateUtil.DATE_PATTERN_ALL2, getEvDay(-2)+"000000"));
		System.out.println(DateUtil.parse(DateUtil.DATE_PATTERN_ALL2, getEvDay(-2)+"235959"));
	}
}
