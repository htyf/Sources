package cn.oracel.oaec.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;

import cn.oracel.oaec.entity.Emp;
import cn.oracel.oaec.util.HibernateUtils;

public class SelectByHQL {

	public static void main(String[] args) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = session.beginTransaction();
		selectByPage(session);
		
		System.out.println("over");
	}

	//��ҳ��ѯ
	private static void selectByPage(Session session) {
		//��ҳ��ѯ
		Query query = session.createQuery("from Emp");
		
		//��ǰҳ
		int currentPage=4;
		//ÿҳ��ʾ����
		int pageRows=3;
		
		//����һ�����ݿ�ʼ���ң���һ�����±���0��
		query.setFirstResult((currentPage-1)*pageRows);
		//��ѯ������¼
		query.setMaxResults(pageRows);
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

	
	//ͶӰ��ѯ����ѯ�������ԣ�����װ��������ȥ��
	private static void selectByTouYin(Session session) {
		//1.����һ�����췽��������Ĳ�������������Ҫ��ѯ����
		//��װ��ѯ���new Emp(uid,uname)
		Query query = session.createQuery("select new Emp(uid,uname) from Emp");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

//�����ѯ
	private static void selectByOrder(Session session) {
		Query query = session.createQuery("from Emp order by uid desc");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}


	//�ۺϺ����Ĳ�ѯ
	private static void selectByFunction(Session session) {
		//�ۺϺ���,һ���Ƽ�ʹ��Number��Ϊ������
		/*Query query = session.createQuery("select sum(e.uid) from Emp e");
		List<Number> list = query.list();
		Number result = list.get(0);
		System.out.println(result);*/
		
		Query query = session.createQuery("select count(*) from Emp e");
		Number uniqueResult = (Number) query.uniqueResult();
		
		double result=uniqueResult.doubleValue();
		System.out.println(result);
	}
	
	
	
	/*
	 * ������ѯ
	 * ��ʽһ
	 * Query query = session.createQuery("from Emp e where e.dept.did=?");
	 * query.setParameter(0, 2);
	 * 
	 * 
	 * ��ʽ��ʽ�����Ƽ���
	 * Query query = session.createQuery("from Emp e where e.dept.did= :did");
	 * query.setParameter("did", dept.getDid());
	 * 
	 * ���ַ�ʽ��������ʹ�ã����ǲ�Ҫ����ʹ��
	 */
	private static void selectByWhere(Session session) {
		//��ס���������ж����е�����ʱ��һ��Ҫ����ѯ�Ķ���ӱ���
		//Query query = session.createQuery("from Emp e where e.dept.did=1");
		//ʹ�ô�ͳ��ռλ���ķ�ʽ���ݲ���
		//Query query = session.createQuery("from Emp e where e.dept.did=?");
		//hibernate�ṩ��ռλ����ʽ���ݲ���  �̶�д�� ��  ������ ��,ð�Ų�����
		Query query = session.createQuery("from Emp e where e.dept.did=   :qqqfdfds");
		//���ò���(��ͳ��ʽ)
		//query.setInteger(0, 2);
		//ͨ�÷�ʽ(�Ƽ�ʹ�ã�����Ҫ���Ǵ��������)
//		query.setParameter(0, 2);
		query.setParameter("qqqfdfds", 2);
		
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

	//һ���ѯ
	private static void s1(Session session) {
		//ͨ��session����query��ѯ����
		Query query = session.createQuery("from Emp");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

}
