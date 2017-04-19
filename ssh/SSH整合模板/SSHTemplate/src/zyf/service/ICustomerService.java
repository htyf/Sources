package zyf.service;

import zyf.dao.ICustomerDao;
import zyf.entity.Customer;

public interface ICustomerService {
	
	public void add(Customer cust) throws Exception;

}
