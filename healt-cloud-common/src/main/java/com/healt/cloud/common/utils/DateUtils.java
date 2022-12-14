package com.healt.cloud.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

	/**
	 * 根据当前时间生成yyyyMMddHHmmss字符串
	 * @return
	 */
	public static String getDateYYYYMMDDHHMMSS(){
		return DateUtils.praseDate(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 给定Date对象，生成yyyyMMddHHmmss字符串
	 * @param date
	 * @return
	 */
	public static String getDateYYYYMMDDHHMMSS(Date date){
		return DateUtils.praseDate(date, "yyyyMMddHHmmss");
	}

	/**
	 * 对日期按指定格式格式化为字符串
	 * @param date 需要格式化的日期对象
	 * @param formater 格式模版
	 * @return String 格式化后的日期字符串
	 */
	public static String praseDate(Date date, String formater) {
		SimpleDateFormat format = new SimpleDateFormat(formater);
		return format.format(date);
	}
	/**
	 * 日期格式字符串转换为Date对象
	 * @param dateStr 日期格式字符串
	 * @return Date对象
	 */
	public static Date parseString(String dateStr, String formater) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(formater);
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据出生日期计算年龄
	 * @param birthday
	 * @return
	 */
	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthday)) {
			throw new IllegalArgumentException("出生日期大于当前系统时间！");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.parseString("20220812122641","yyyyMMddHHmmss"));
	}
	
}
