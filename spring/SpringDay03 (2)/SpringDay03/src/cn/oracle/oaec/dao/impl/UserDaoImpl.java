package cn.oracle.oaec.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.oracle.oaec.dao.IUserDao;

@Component(value="userDao")
public class UserDaoImpl implements IUserDao {
	
//	@Resource(name="session")
//	private Session session;
	@Override
	public void save() {
//		int i=10/0;
		System.out.println("dao...save...");

	}

	@Override
	public void update() {
		System.out.println("dao...update...");
	}

}
