package cn.oracel.oaec.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class SelectByOID {

	public static void main(String[] args) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		Emp emp = session.get(Emp.class,2);
		System.out.println(emp);
	}

}
