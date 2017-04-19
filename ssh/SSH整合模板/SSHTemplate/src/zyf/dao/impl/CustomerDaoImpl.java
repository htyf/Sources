package zyf.dao.impl;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zyf.dao.ICustomerDao;
import zyf.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements ICustomerDao {

	@Override
	public void add(Customer customer) throws Exception {
		Session session = this.getSessionFactory().getCurrentSession();
//		session.save(customer);
//		Customer cs = session.get(Customer.class, "402882b05a6efb9c015a6efc08980000");
		Customer cs = session.load(Customer.class, "402882b05a6efb9c015a6efc08980000");//懒加载
		System.out.println(cs);
		System.out.println("dao........add");
		
	}

}
