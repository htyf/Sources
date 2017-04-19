package cn.oracel.oaec.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Dept;
import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class Test {

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
		e2.setDept(d1);
		e3.setDept(d2);
		
		//保存
		session.save(e1);
		session.save(e2);
		session.save(e3);
	
		tr.commit();
	}

	private static void m4() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建员工
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		//创建部门
		Dept d1=new Dept("dept1");
		Dept d2=new Dept("dept2");
				
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d2.getEmps().add(e3);
		
		//保存
		//在部门设置不维护外键
		session.save(d1);
		session.save(d2);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		
		tr.commit();
	}
	
	//级联操作2
	private static void m3() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建员工
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		//创建部门
		Dept d1=new Dept("dept1");
		Dept d2=new Dept("dept2");
		
		//创建关联关系
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d2);
		
		//保存
		//在员工设置级联操作
		session.save(e1);
		session.save(e2);
		session.save(e3);

		
		
		
		
		tr.commit();
	}

	//级联操作1
	private static void m2() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建员工
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		//创建部门
		Dept d1=new Dept("dept1");
		Dept d2=new Dept("dept2");
		
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d2.getEmps().add(e3);
		
		//保存
		//在部门设置级联操作
		session.save(d1);
		session.save(d2);

		
		
		
		
		tr.commit();
	}

	//普通添加数据
	private static void m1() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		//创建员工
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		//创建部门
		Dept d1=new Dept("dept1");
		Dept d2=new Dept("dept2");
		
		//创建关联关系
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d2);
		
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d2.getEmps().add(e3);
		
		//保存
		session.save(d1);
		session.save(d2);

		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		
		
		tr.commit();
	}

}
