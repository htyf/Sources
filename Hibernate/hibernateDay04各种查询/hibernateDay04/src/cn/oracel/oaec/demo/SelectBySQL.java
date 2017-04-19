package cn.oracel.oaec.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class SelectBySQL {
	//∆’Õ®≤È—Ø
	@Test
	public void s1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		SQLQuery query = session.createSQLQuery("select * from t_emp");
		
		query.setProperties(new Emp());
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
		
	}
}
