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

	//分页查询
	private static void selectByPage(Session session) {
		//分页查询
		Query query = session.createQuery("from Emp");
		
		//当前页
		int currentPage=4;
		//每页显示条数
		int pageRows=3;
		
		//从哪一条数据开始查找（第一条的下标是0）
		query.setFirstResult((currentPage-1)*pageRows);
		//查询几条记录
		query.setMaxResults(pageRows);
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

	
	//投影查询（查询部分属性，并封装到对象中去）
	private static void selectByTouYin(Session session) {
		//1.创建一个构造方法，传入的参数就是我们需要查询的列
		//封装查询结果new Emp(uid,uname)
		Query query = session.createQuery("select new Emp(uid,uname) from Emp");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

//排序查询
	private static void selectByOrder(Session session) {
		Query query = session.createQuery("from Emp order by uid desc");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}


	//聚合函数的查询
	private static void selectByFunction(Session session) {
		//聚合函数,一般推荐使用Number作为父类型
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
	 * 条件查询
	 * 方式一
	 * Query query = session.createQuery("from Emp e where e.dept.did=?");
	 * query.setParameter(0, 2);
	 * 
	 * 
	 * 方式方式二（推荐）
	 * Query query = session.createQuery("from Emp e where e.dept.did= :did");
	 * query.setParameter("did", dept.getDid());
	 * 
	 * 两种方式可以任意使用，但是不要交替使用
	 */
	private static void selectByWhere(Session session) {
		//记住，条件中有对象中的属性时，一定要给查询的对象加别名
		//Query query = session.createQuery("from Emp e where e.dept.did=1");
		//使用传统的占位符的方式传递参数
		//Query query = session.createQuery("from Emp e where e.dept.did=?");
		//hibernate提供的占位符方式传递参数  固定写法 【  ：名字 】,冒号不能少
		Query query = session.createQuery("from Emp e where e.dept.did=   :qqqfdfds");
		//设置参数(传统方式)
		//query.setInteger(0, 2);
		//通用方式(推荐使用，不需要考虑传入的类型)
//		query.setParameter(0, 2);
		query.setParameter("qqqfdfds", 2);
		
		
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

	//一般查询
	private static void s1(Session session) {
		//通过session创建query查询对象
		Query query = session.createQuery("from Emp");
		List<Emp> list = query.list();
		for(Emp e:list){
			System.out.println(e);
		}
	}

}
