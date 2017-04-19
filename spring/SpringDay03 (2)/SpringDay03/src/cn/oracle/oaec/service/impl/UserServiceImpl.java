package cn.oracle.oaec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.oracle.oaec.aop.MyTransaction;
import cn.oracle.oaec.dao.IUserDao;
import cn.oracle.oaec.service.IUserService;

@Component(value="userService")
public class UserServiceImpl implements IUserService {

	@Resource(name="userDao")
	private IUserDao dao;
	
	
	@Override
	public void userSave() {
		//��������
		dao.save();
		//�ύ����
	}

	@Override
	public void userUpdate() {
		//��������
		dao.update();
		//�ύ����
	}

	@Override
	public void selectUser() {
		System.out.println("��û������...");
		
	}
	

}
