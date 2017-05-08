package com.demo.hr.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 常量定义
 * @author quyf
 *
 */
public class Constants {
	public static final String HR_DOMAIN = "";//域名
	
	//public static final String HR_NODE_DOMAIN = "http://172.30.0.55:8000/#/feedback";//前端系统地址
	//public static final String HR_NODE_DOMAIN = "http://localhost:8000/#/feedback";//前端系统地址
	public static final String HR_NODE_DOMAIN = "http://hr.xxx.com/#/feedback";//前端系统地址

	public static final int FAILURE_NOTIFY_DAYS = 2;//淘汰邮件在几个工作日之后发送
	public static final Integer PAGE_SIZE = 20;
	public static final Integer PAGE_NO = 1;
	
	@SuppressWarnings("serial")
	public static final ArrayList<String> locations = new ArrayList<String>(){//面试地址
		{
			add("深圳南山区讯美大厦2号");
			add("北京市海淀区用友产业园中区8号楼");
			add("深圳市福田区深南中路2070号5");
			add("中山市东区兴政路1号中环广场");
			add("苏州工业园区苏绣路89号");
		}
	};
	//应聘渠道
	public static final Map<Integer,String> originMap = new HashMap<Integer,String>( 16 );
	//电话预约情况
	public static final Map<Integer,String> phonePreMap = new HashMap<Integer,String>( 16 );
	//复试结果
	public static final Map<Integer,String> fsResultMap = new HashMap<Integer,String>( 16 );
	//初试结果
	public static final Map<Integer,String> csResultMap = new HashMap<Integer,String>( 16 );
	//简历获取方式
	public static final Map<Integer,String> profileWayMap = new HashMap<Integer,String>( 16 );
	
	//初始化各类变量
	static{
		originMap.put(0,"无"); 			originMap.put(1,"前程无忧");
		originMap.put(2,"智联招聘"); 		originMap.put(3,"拉勾网");
		originMap.put(4,"猎聘网"); 		originMap.put(5,"校园招聘");
		originMap.put(6,"内部推荐"); 		originMap.put(7,"猎头推荐");
		originMap.put(8,"boss直聘"); 		originMap.put(9,"脉脉");
		originMap.put(10,"LINKEDIN");	originMap.put(11,"微信");
		originMap.put(12,"其他渠道");
		
		phonePreMap.put(0, "暂无");			phonePreMap.put(1, "电话淘汰");	
		phonePreMap.put(2, "待候选人考虑");		phonePreMap.put(3, "候选人不考虑");
		
		csResultMap.put(0, "暂无");			csResultMap.put(1, "复试");	
		csResultMap.put(2, "存档备选 ");		csResultMap.put(3, "不合格");
		
		fsResultMap.put(0, "暂无");			fsResultMap.put(1, "聘用");	
		fsResultMap.put(2, "存档备选");		fsResultMap.put(3, "不合格");
		
		profileWayMap.put(0, "暂无");			profileWayMap.put(1, "主动投递");	
		profileWayMap.put(2, "简历下载");		profileWayMap.put(3, "推荐人");
		
	}
	
	public static void main(String[] args) {
		System.out.println( JSON.toJSON(locations));
		
	}
}
