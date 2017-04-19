package cn.oracel.oaec.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Dept;
import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class Test1 {

	public static void main(String[] args) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建员工
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		//创建部门
		Dept d1=new Dept("dept1");
		Dept d2=new Dept("dept2");
		
			
		e1.setDept(d1);
		
		
		session.save(e1);
		
		
		
		
		
		
		
		tr.commit();
	}

}
