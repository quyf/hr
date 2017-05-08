package com.demo.hr.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadFileInitSqlUtil {

	public static void main(String[] args) throws IOException {
		//initPostSql();
		initStaffSql();
	}
	/**
	 * 初始化面试官信息
	 * @throws IOException
	 */
	public static void initStaffSql() throws IOException{
		String dir = "src/main/resources/sql/";
		File file = new File(dir+ "interviewer.txt");
		File sqlFile = new File(dir+"03_init_interviewer.sql");
		List<String> lines = FileUtils.readLines(file,"UTF-8");
		StringBuilder sb = new StringBuilder("INSERT INTO `staff` (`name`, `email`, `department`, `status`, `type`) VALUES");
		for(String line:lines){
			sb.append("\n");
			String[] data = line.split("\\|");
			sb.append( "('"+data[0].trim()+"','"+data[2].trim()+"','"+data[1].trim()+"',1,0),");
			//System.out.println( data[0]+"==="+data[1]);
		}
		FileUtils.writeStringToFile(sqlFile, sb.toString(), "utf-8", true);
	}
	
	/**
	 * 初始化招聘岗位sql
	 * @throws IOException
	 */
	public static void initPostSql() throws IOException{
		String dir = "src/main/resources/sql/";
		File file = new File(dir+ "post.txt");
		File sqlFile = new File(dir+"04_init_post.sql");
		List<String> lines = FileUtils.readLines(file,"UTF-8");
		StringBuilder sb = new StringBuilder("INSERT INTO `post` (`post`, `post_link`, `status`) VALUES");
		for(String line:lines){
			sb.append("\n");
			String[] data = line.split("\\|");
			if( data.length>1 ){
				sb.append( "('"+data[0].trim()+"','"+data[1].trim()+"',1)," );
			}else{
				sb.append( "('"+data[0].trim()+"','',1)," );
			}
			//System.out.println( data[0]+"==="+data[1]);
		}
		FileUtils.writeStringToFile(sqlFile, sb.toString(), "utf-8", true);
	}
}
