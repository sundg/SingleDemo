package com.per.sundg.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ztesoft
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
		"yyyyMMdd", "yyyyMMddHHmmss", "yyyyMMddHHmm", "yyyyMM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(DateFormatUtils.format(getFirstOfThisMonth(),"yyyy-MM-dd 00:00:00"));
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}

  /**
   * 获取本周的周一，如果当天是周一，获取上周周一
   * @return
   */
  public static Date getMondayOfThisWeek(Date date) {
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    if(c.get(Calendar.DAY_OF_WEEK) == 2){
      c.add(Calendar.DAY_OF_MONTH, -7);
    }else{
      c.set(Calendar.DAY_OF_WEEK, 2);
    }
    return c.getTime();
  }

	/**
	 * 获取本周的周日，如果当天是周日，获取上周周日
	 * @return
	 */
	public static Date getSundayOfLastWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_WEEK) == 1){
			c.add(Calendar.DAY_OF_MONTH, -7);
		}else{
			c.set(Calendar.DAY_OF_WEEK, 1);
		}
		return c.getTime();
	}

  /**
   * 获取本月1号。如果当天是本月1号。获取上月1号
   * @param date
   * @return
   */
  public static Date getFirstOfThisMonth(Date date){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    if(c.get(Calendar.DAY_OF_MONTH)==1){
      c.add(Calendar.MONTH, -1);
    }else{
      c.set(Calendar.DAY_OF_MONTH, 1);
    }
    return c.getTime();
  }
	/**
	 * 获取本月1号。如果当天是本月1号
	 * @param
	 * @return
	 */
	public static Date getFirstOfThisMonth(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}


	/**
	 * 获取上月第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstOfLastMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_MONTH)!=1){
			c.set(Calendar.DAY_OF_MONTH, 1);
		}
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}


	/**
   * 获取上月最后一天
   * @param date
   * @return
   */
  public static Date getLastOfLastMonth(Date date){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    if(c.get(Calendar.DAY_OF_MONTH)!=1){
      c.set(Calendar.DAY_OF_MONTH, 1);
    }
    c.add(Calendar.DAY_OF_MONTH, -1);
    return c.getTime();
  }

  /**
   * 获取本月最后一天
   * @param date
   * @return
   */
  public static Date getLastOfThisMonth(Date date){
    Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
    return c.getTime();
  }

  /**
   * 统计每周和月的最后一天。星期日和月底最后一天
   * @param date 统计日期
   * @param period 周期
   * @param num 返回多少段
   * @return
   */
  public static Date[] getDateEndPeriod(Date date, int period, int num){
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);

    date = calendar.getTime();
    Date[] datePeriod = new Date[num];
    //period 1:日  2:周  3:月
    if(period == 1){
      for(int i=num;i>0;i--){
        datePeriod[num-i] = addDays(date, 0-i);
      }
    }
    if(period == 2){
      //获取本周的周一，如果当天是周一，获取上周的周一
      date = addDays(date, -1);
      datePeriod[num-1] = date;

      date = getSundayOfLastWeek(date);

      //获取最近num个周的周日
      for(int i=num-2;i>=0;i--){
        datePeriod[num-i-2] = addWeeks(date, 0-i);
      }
    }
    if(period == 3){
      date = addDays(date, -1);
      datePeriod[num-1] = date;
      //获取最近num个月的最后一天。本月最后一天是昨天。
      date = getLastOfLastMonth(date);
      for(int i=num-2;i>=0;i--){
        //每个月的最后一天
        datePeriod[num-i-2] = getLastOfThisMonth(addMonths(date, 0-i));
      }
    }
    return datePeriod;
  }

	/**
	 * 统计周和月的第一天。星期一和一号
	 * @param date 统计日期
	 * @param period 周期
	 * @param num 返回多少段
	 * @return
   */
	public static Date[] getDateStartPeriod(Date date, int period, int num){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		date = calendar.getTime();
    Date[] datePeriod = new Date[num];
		//period 1:日  2:周  3:月
		if(period == 1){
      for(int i=num;i>0;i--){
        datePeriod[num-i] = addDays(date, 0-i);
      }
    }
		if(period == 2){
      //获取本周的周一，如果当天是周一，获取上周的周一
      date = getMondayOfThisWeek(date);

      //获取最近num个周的周一
      for(int i=num-1;i>=0;i--){
        datePeriod[num-i-1] = addWeeks(date, 0-i);
      }
		}
		if(period == 3){
      date = getFirstOfThisMonth(date);
      for(int i=num-1;i>=0;i--){
        datePeriod[num-i-1] = addMonths(date, 0-i);
      }
		}
		return datePeriod;
	}

	/**
	 * 获取昨天凌晨0点整
	 * @return
   */
	public static Date getYesterday(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		date = calendar.getTime();
		date = DateUtils.addDays(date, -1);
		return date;
	}

	public static int getSeconds(String date){
		int seconds = 0;
		try {
			Date d = DateUtils.parseDate(date, "HH:mm:ss");
			seconds = d.getHours()*3600+d.getMinutes()*60+d.getSeconds();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return seconds;
	}

	/**
	 * 获取当年的第一天
	 * @return
   */
	public static Date getCurrYearFirst(){
		Calendar currCal=Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取去年最后一天
	 * @return
   */
	public static Date getLastYearlast(){
		return new Date(getCurrYearFirst().getTime()- 24*60*60*1000);
	}


	/**
	 * 获取某年第一天日期
	 * @param year 年份
	 * @return Date
	 */
	public static Date getYearFirst(int year){
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 将字符串的日期转换成longStringYMD
	 *
	 * @param date 字符串的日期
	 * @return
	 */
	public static String dateStringToLongYmd(String date) {
		if (StringUtils.isNotBlank(date)) {
			Date d = null;
			try {
				d = DateUtils.parseDate(date, "yyyy-MM-dd");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (d != null) {
				long time = d.getTime();
				return String.valueOf(time);
			}
		}
		return "";
	}

	/**
	 * 将字符串的日期转换成longStringYMdHm
	 *
	 * @param date 字符串的日期
	 * @return
	 */
	public static String dateStringToLongYMdHm(String date) {
		if (StringUtils.isNotBlank(date)) {
			Date d = null;
			try {
				d = DateUtils.parseDate(date, "yyyy-MM-dd HH:mm");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (d != null) {
				long time = d.getTime();
				return String.valueOf(time);
			}
		}
		return "";
	}

	/**
	 * 将字符串的日期转换成longStringYMdHm
	 *
	 * @param date 字符串的日期
	 * @return
	 */
	public static String dateStringToLongYMdHms(String date) {
		if (StringUtils.isNotBlank(date)) {
			Date d = null;
			try {
				d = DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (d != null) {
				long time = d.getTime();
				return String.valueOf(time);
			}
		}
		return "";
	}

    /**
     * 将long类型的时间转换成字符串(yyyy-MM-dd HH:mm)
     * @param l
     * @return
     */
    public static String longToDateString(String l) {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(l)) {
            Long time = Long.valueOf(l);
            if (time > 0) {
                Date date = new Date(time);
                String d = DateUtils.formatDate(date, "yyyy-MM-dd HH:mm");
                return d;
            }
        }
        return "";
    }

}
