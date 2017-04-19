package cn.oracle.oaec.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.oracle.oaec.service.IUserService;

//通过spring支持的junit测试可以简化代码
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
//		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Resource(name="userService")
	private IUserService service;
	
	@Test
	public void save(){
		
		service.userSave();
		service.userUpdate();
	
		
	}
}
