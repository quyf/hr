package com.demo.hr.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class HrUtils {

	private static int cpu = Runtime.getRuntime().availableProcessors();// cpu核心数

	public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpu, new ThreadFactory() {
		private AtomicInteger threadIndex = new AtomicInteger(0);

		public Thread newThread(Runnable r) {
			return new Thread(r, "hr_thread_" + this.threadIndex.incrementAndGet());
		}
	});

	public static void submit(Runnable job) {
		fixedThreadPool.submit(job);
	}

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static String format(Date date) {
		return format.format(date);
	}

	public static Date addHour(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}
	
	/**
	 * 返回day个工作日的时间
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDateByWorkDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		try {
			for (int i = 0; i < day; i++) {
				calendar.add(Calendar.DAY_OF_MONTH, 1);
				if (checkHoliday(calendar)) {
					i--;
				}
			}
			return calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return calendar.getTime();
	}
	
	// 节假日列表
	private static List<Calendar> holidayList = new ArrayList<Calendar>(); 

	/**
	 * 验证日期是否是节假日
	 * @param calendar 传入需要验证的日期
	 * @return return boolean 返回类型 返回true是节假日，返回false不是节假日 throws date
	 */
	public static boolean checkHoliday(Calendar calendar) throws Exception {

		// 判断日期是否是周六周日
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			return true;
		}
		// 判断日期是否是节假日
		for (Calendar ca : holidayList) {
			if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
					&& ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
					&& ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
				return true;
			}
		}

		return false;
	}

	/**
	 *把所有节假日放入list
	 * @param date
	 */
	static {
		@SuppressWarnings("serial")
		List<String> dateList = new ArrayList<String>(){
			{ 
				add("2017-04-29");add("2017-04-30");add("2017-05-01");
				add("2017-05-28");add("2017-05-29");add("2017-05-30");
				add("2017-10-01");add("2017-10-02");add("2017-10-03");add("2017-10-04");
				add("2017-10-05");add("2017-10-06");add("2017-10-07");add("2017-10-08");
			}
		};
		for( String date:dateList){
			String[] da = date.split("-");
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
			calendar.set(Calendar.MONTH, Integer.valueOf(da[1]) - 1);// 月份比正常小1,0代表一月
			calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
			holidayList.add(calendar);
		}
	}
	
	public static String mapToString(Map<String,Object> data){
		
		return JSON.toJSONString(data);
//		StringBuffer sb = new StringBuffer();
//		for (Map.Entry<String, Object> entry : data.entrySet()) {
//			String name = entry.getKey().toString();
//			String value = String.valueOf(entry.getValue());
//			if (value != null) {
//				sb.append(name + "=" + value + "&");
//			}
//		}
//		int len = sb.length();
//		sb = sb.deleteCharAt(len-1);
//		return sb.toString();
	}
	
	public static String URLEncoder(String str){
		try {
			return URLEncoder.encode(str,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String encoder(String str){
		try {
			return new BASE64Encoder().encode(str.getBytes("utf-8")).replaceAll("\n", "").replaceAll("\r", "");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String decoder(String str){
		try {
			return new String(new BASE64Decoder().decodeBuffer(str),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("name", "quyf11");
		m.put("helllo", "world");
		System.out.println( encoder(mapToString(m)));
		
		String in = "eyJmZWVkYmFja190YXNrX2lkIjoyNCwicG9zdCI6Iu+7v+S6p+WTgei/kOiQpeWylyIsInBlcnNvbl9pZCI6MjUsInBlcnNvbl9uYW1lIjoi5b6F5YiG6YWNIiwic3RhZmZfbmFtZSI6IuWxiOS6mumUiyIsIm1zX3R5cGUiOjAsImZlZWRiYWNrX3R5cGUiOjEsInBvc3RfbGluayI6Imh0dHBzOi8vd3d3LmxpZXBpbi5jb20vIiwic3RhZmZfaWQiOjEsImludGVydmlld19pZCI6MTZ9";
		System.out.println( decoder(in));
	}
}
