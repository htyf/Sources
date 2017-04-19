package cn.oracle.oaec.action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.oracle.oaec.sersvicec.UserServiceImpl;
import cn.oracle.oaec.service.IUserService;

public class UserAction {
	@Test
	public void save(){
		//����spring����
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ��Ӧ���ֵ�bean
		IUserService service=(IUserService) c.getBean("userService");
		service.save();
		
	}
}
