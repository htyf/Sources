package cn.oracel.oaec.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class SelectByQBC {

	//or查询
	@Test
	public void s8(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class,"e");
		
		c.add(Restrictions.or(Restrictions.ge("e.uid", 5),Restrictions.eq("e.dept.did", 2)));
		
		
		List<Emp> list = c.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}
	//分页查询
	@Test
	public void s7(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//当前页
		int currentPage=2;
		//每页显示条数
		int pageRows=3;
		
		//从哪一条数据开始查找（第一条的下标是0）
		c.setFirstResult((currentPage-1)*pageRows);
		//查询几条记录
		c.setMaxResults(pageRows);
		
		List<Emp> list = c.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}
	//排序查询
	@Test
	public void s6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		c.addOrder(Order.asc("uid"));
		
		
		List<Emp> result = c.list();
		for (Emp emp : result) {
			System.out.println(emp);
		}
		
	}
	//投影查询之返回Emp对象
	/*
	 * 1.创建Criteria对象的时候需要给别名
	 * 2.添加集合的时候也需要使用别名，别名要与属性名一致
	 * 3.类型转换器转换成对象
	 * select e.uid as uid ,e.uname as uname from t_emp as e
	 */
	@Test
	public void s5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class,"e");
		
		//创建需要查询的属性集合
		ProjectionList list=Projections.projectionList();
		list.add(Projections.property("e.uid"),"uid");
		list.add(Projections.property("e.uname"),"uname");
		
		//添加查询的属性集合
		c.setProjection(list);
		
		//通过类型转换器转换成Emp对象
		c.setResultTransformer(Transformers.aliasToBean(Emp.class));
		
		List<Emp> result = c.list();
		for (Emp emp : result) {
			System.out.println(emp);
		}
		
	}
	//投影查询之返回Object[]
	@Test
	public void s4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//创建需要查询的属性集合
		ProjectionList list=Projections.projectionList();
		list.add(Projections.property("uid"));
		list.add(Projections.property("uname"));
		
		//添加查询的属性集合
		c.setProjection(list);
		
		List<Object[]> result = c.list();
		for (Object[] emp : result) {
			System.out.println(Arrays.toString(emp));
		}
		
	}
	//聚合函数查询
	@Test
	public void s3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//设置聚合函数
//		c.setProjection(Projections.count("uid"));
		//如果是count(*)
		c.setProjection(Projections.rowCount());
		
		
		List<Number> list = c.list();
		Number number = list.get(0);
		System.out.println(number);
	}
	//带条件查询
	@Test
	public void s2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		//添加条件
		c.add(Restrictions.ge("uid", 5));
		c.add(Restrictions.eq("dept.did", 1));
		List<Emp> list = c.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//普通查询
	@Test
	public void s1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		List<Emp> list = c.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
