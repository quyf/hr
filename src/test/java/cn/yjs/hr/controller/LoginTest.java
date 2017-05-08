package cn.yjs.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import com.alibaba.fastjson.JSON;
import com.demo.hr.controller.HrController;
import com.demo.hr.controller.LoginController;
import com.demo.hr.controller.cmd.AddPersonCmd;
import com.demo.hr.controller.cmd.AddPersonCmdTest;
import com.demo.hr.utils.Result;

import cn.yjs.hr.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLogin() throws Exception{
		LoginController loginContr = (LoginController)ac.getBean("loginController");
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpSession session = new MockHttpSession();
		request.setSession( session );
		
		request.setMethod("POST");
		//request.addParameter("xx", "aa");
		
		Result rt = loginContr.login(request, "xxx", "xxx", 0, null);
		System.out.println( "login===>"+JSON.toJSONString( rt ));
//		
		AddPersonCmdTest cmd = new AddPersonCmdTest();
		cmd.setAccount("1111");
		cmd.setName("quyf");
		List<String> list = new ArrayList<String>();
		list.add("423423");
		list.add("wwww");
		list.add("aaaa");
		cmd.setList(list);
//		String s = loginContr.test(request, session,cmd);
//		System.out.println(s);
		
		HrController hrController = (HrController)ac.getBean("hrController");
		
		AddPersonCmd addCmd = new AddPersonCmd();
		addCmd.setName("quyf2");
		addCmd.setPost("高开");
		addCmd.setMobile("xxx");
		addCmd.setEmail("xxxx@qq.com");
		addCmd.setOrigin(1);
		addCmd.setPreInfo(0);
		addCmd.setWay(0);
		addCmd.setNote("技术扎实");
		rt = hrController.list(request, 1, "quyf");
		System.out.println("addPerson====>"+JSON.toJSONString( rt ));
	}
	
	
}
