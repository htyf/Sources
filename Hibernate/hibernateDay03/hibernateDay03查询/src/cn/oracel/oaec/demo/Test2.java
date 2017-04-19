package cn.oracel.oaec.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.entity.Privilege;
import cn.oracel.oaec.util.HibernateUtils;

public class Test2 {

	public static void main(String[] args) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Emp e1=new Emp("tom1");
		Emp e2=new Emp("tom2");
		Emp e3=new Emp("tom3");
		
		Privilege p1=new Privilege("p1");
		Privilege p2=new Privilege("p2");
		
		e1.getPris().add(p1);
		e1.getPris().add(p2);
		e2.getPris().add(p2);
		e3.getPris().add(p2);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		
		
		/*p1.getEmps().add(e1);
		p1.getEmps().add(e2);
		p2.getEmps().add(e3);
		
		session.save(p1);
		session.save(p2);*/
		
		tr.commit();

	}

}
