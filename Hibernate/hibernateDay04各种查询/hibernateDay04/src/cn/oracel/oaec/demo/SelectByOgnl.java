package cn.oracel.oaec.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.oracel.oaec.entity.Dept;
import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class SelectByOgnl {
	public static void main(String[] args) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Dept dept = session.get(Dept.class, 1);
		
		
		Set<Emp> emps = dept.getEmps();
		for(Emp e:emps){
			System.out.println(e);
		}
	}
}
