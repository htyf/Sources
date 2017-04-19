package cn.oracel.oaec.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Dept;
import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class Demo1 {

	public static void main(String[] args) {
		
		//
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		
		saveByDept(session);
		
		
		tr.commit();
	}

	private static void deleteByEmp(Session session) {
		//3条sql语句
		Emp emp = session.get(Emp.class, 1);
		emp.setDept(null);
	}

	private static void deleteByDept(Session session) {
		//4条sql
		Emp emp = session.get(Emp.class, 1);
		Dept d=session.get(Dept.class, 2);
		d.getEmps().remove(emp);
	}

	private static void updateEmp(Session session) {
		//3条sql
		Emp emp = session.get(Emp.class, 1);
		Dept d=session.get(Dept.class, 2);
		emp.setDept(d);
		session.update(emp);
	}

	private static void saveByEmp(Session session) {
		Dept d1=new Dept("d1");
		Dept d2=new Dept("d2");
		
		Emp e1=new Emp("e1", d1);
		Emp e2=new Emp("e2", d1);
		Emp e3=new Emp("e3", d1);
		Emp e4=new Emp("e4", d1);
		Emp e5=new Emp("e5", d1);
		Emp e6=new Emp("e6", d2);
		Emp e7=new Emp("e7", d2);
		Emp e8=new Emp("e8", d2);
		Emp e9=new Emp("e9", d2);
		
		
		//11条sql
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.save(e6);
		session.save(e7);
		session.save(e8);
		session.save(e9);
	}

	private static void saveByDept(Session session) {
		Dept d1=new Dept("d1");
		Dept d2=new Dept("d2");
		
		/*Emp e1=new Emp("e1");
		Emp e2=new Emp("e2");
		Emp e3=new Emp("e3");
		Emp e4=new Emp("e4");
		Emp e5=new Emp("e5");
		Emp e6=new Emp("e6");
		Emp e7=new Emp("e7");
		Emp e8=new Emp("e8");
		Emp e9=new Emp("e9");*/
		
		Emp e1=new Emp("e1", d1);
		Emp e2=new Emp("e2", d1);
		Emp e3=new Emp("e3", d1);
		Emp e4=new Emp("e4", d1);
		Emp e5=new Emp("e5", d1);
		Emp e6=new Emp("e6", d2);
		Emp e7=new Emp("e7", d2);
		Emp e8=new Emp("e8", d2);
		Emp e9=new Emp("e9", d2);
		
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		d1.getEmps().add(e3);
		d1.getEmps().add(e4);
		d1.getEmps().add(e5);
		
		d2.getEmps().add(e6);
		d2.getEmps().add(e7);
		d2.getEmps().add(e8);
		d2.getEmps().add(e9);
		
		//20条sql语句
		session.save(d1);
		session.save(d2);
	}

}
