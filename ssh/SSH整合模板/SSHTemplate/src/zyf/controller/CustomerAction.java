package zyf.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zyf.entity.Customer;
import zyf.service.ICustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1215175513422696389L;
	/*******封装数据********/
	Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	/*******封装数据********/
	

	/*******具体处理事情：
	 * 通过spring注入业务层的具体实现类**************
	 */
	private ICustomerService service;
	public void setService(ICustomerService service) {
		this.service = service;
	}
	/****************************************************/
	public String add(){
		try {
			service.add(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	
}
