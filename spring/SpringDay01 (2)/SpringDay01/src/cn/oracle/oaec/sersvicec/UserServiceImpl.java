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
		
		
		
		
		
		
		
		
		
		
		/*//����spring����
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ��Ӧ���ֵ�bean
		IUserDao dao = (IUserDao) c.getBean("userDao");
		IUserDao bean = (IUserDao)c.getBean("userDao");
		//���ö���ķ���
		 bean.save();
		System.out.println("UserServiceImpl...save");*/
	}

}
