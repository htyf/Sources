package cn.oracle.oaec.sersvicec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.oracle.oaec.dao.IUserDao;
import cn.oracle.oaec.dao.UserDaoImpl;
import cn.oracle.oaec.dao.UserDaoImplByHibernate;
import cn.oracle.oaec.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao dao;
	
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	

	@Override
	public void save() {
		
		dao.save();
		
		
		
		
		
		
		
		
		
		
		/*//加载spring容器
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取对应名字的bean
		IUserDao dao = (IUserDao) c.getBean("userDao");
		IUserDao bean = (IUserDao)c.getBean("userDao");
		//调用对象的方法
		 bean.save();
		System.out.println("UserServiceImpl...save");*/
	}

}
