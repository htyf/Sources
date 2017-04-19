package cn.oracle.oaec.action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.oracle.oaec.sersvicec.UserServiceImpl;
import cn.oracle.oaec.service.IUserService;

public class UserAction {
	@Test
	public void save(){
		//加载spring容器
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取对应名字的bean
		IUserService service=(IUserService) c.getBean("userService");
		service.save();
		
	}
}
