package zyf.service.impl;

import org.springframework.transaction.annotation.Transactional;

import zyf.dao.ICustomerDao;
import zyf.entity.Customer;
import zyf.service.ICustomerService;

@Transactional
public class CustomerServiceImpl implements ICustomerService {
	private ICustomerDao dao ;
	
	public void setDao(ICustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(Customer cust) throws Exception {
		dao.add(cust);
		System.out.println("service ----------add");
	}

}
