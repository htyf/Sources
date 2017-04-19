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

	//or��ѯ
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
	//��ҳ��ѯ
	@Test
	public void s7(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//��ǰҳ
		int currentPage=2;
		//ÿҳ��ʾ����
		int pageRows=3;
		
		//����һ�����ݿ�ʼ���ң���һ�����±���0��
		c.setFirstResult((currentPage-1)*pageRows);
		//��ѯ������¼
		c.setMaxResults(pageRows);
		
		List<Emp> list = c.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}
	//�����ѯ
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
	//ͶӰ��ѯ֮����Emp����
	/*
	 * 1.����Criteria�����ʱ����Ҫ������
	 * 2.��Ӽ��ϵ�ʱ��Ҳ��Ҫʹ�ñ���������Ҫ��������һ��
	 * 3.����ת����ת���ɶ���
	 * select e.uid as uid ,e.uname as uname from t_emp as e
	 */
	@Test
	public void s5(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class,"e");
		
		//������Ҫ��ѯ�����Լ���
		ProjectionList list=Projections.projectionList();
		list.add(Projections.property("e.uid"),"uid");
		list.add(Projections.property("e.uname"),"uname");
		
		//��Ӳ�ѯ�����Լ���
		c.setProjection(list);
		
		//ͨ������ת����ת����Emp����
		c.setResultTransformer(Transformers.aliasToBean(Emp.class));
		
		List<Emp> result = c.list();
		for (Emp emp : result) {
			System.out.println(emp);
		}
		
	}
	//ͶӰ��ѯ֮����Object[]
	@Test
	public void s4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//������Ҫ��ѯ�����Լ���
		ProjectionList list=Projections.projectionList();
		list.add(Projections.property("uid"));
		list.add(Projections.property("uname"));
		
		//��Ӳ�ѯ�����Լ���
		c.setProjection(list);
		
		List<Object[]> result = c.list();
		for (Object[] emp : result) {
			System.out.println(Arrays.toString(emp));
		}
		
	}
	//�ۺϺ�����ѯ
	@Test
	public void s3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		
		//���þۺϺ���
//		c.setProjection(Projections.count("uid"));
		//�����count(*)
		c.setProjection(Projections.rowCount());
		
		
		List<Number> list = c.list();
		Number number = list.get(0);
		System.out.println(number);
	}
	//��������ѯ
	@Test
	public void s2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		Criteria c = session.createCriteria(Emp.class);
		//�������
		c.add(Restrictions.ge("uid", 5));
		c.add(Restrictions.eq("dept.did", 1));
		List<Emp> list = c.list();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//��ͨ��ѯ
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
