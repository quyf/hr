package cn.yjs.hr;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring.xml"})

public class BaseTest {
	protected ApplicationContext ac = null;

	@Before
	public void before() {
		ac = new ClassPathXmlApplicationContext("spring.xml");
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String url = "account=12125&pwd=456644";
		
		System.out.println( "http://127.0.0.1:8080/hr/login?"+URLEncoder.encode(url, "utf-8"));
	}
}
