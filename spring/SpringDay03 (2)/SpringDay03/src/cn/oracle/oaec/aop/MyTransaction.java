package cn.oracle.oaec.aop;

import java.sql.Connection;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component(value="myTransaction")
@Aspect//��ͬ��<aop:aspect ref="myTransaction"></aop:aspect>
public class MyTransaction {
//	private Session session;
	private Connection con;
	//��ͬ��<aop:around method="transaction"  pointcut="execution( * *..*.*ServiceImpl.*(..))"/>
	@Before(value="execution( * *..*.*ServiceImpl.*(..))")
	public void begingTransaction(){
		System.out.println("��������...");
		/*try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@AfterReturning(value="execution( * *..*.*ServiceImpl.*(..))")
	public void commitTransaction(){
		System.out.println("�ύ����...");
		/*try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@AfterThrowing(value="execution( * *..*.*ServiceImpl.*(..))")
	public void rollbackTransaction(){
		System.out.println("�ع�����...");
		/*try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@After(value="execution( * *..*.*ServiceImpl.*(..))")
	public void doFinally(){
		System.out.println("�ر���Դ...");
		
	}
	
	/*public void transaction(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("��������...");
			
			 * Session s=hiernate.getCurrentSession();
			 * Transaction tr=s.begingTransaction();
			 
			//�͵�ͬ�ڵ���cn.oracle.oaec.service.impl.UserServiceImpl.save();
			
			joinPoint.proceed();
			System.out.println("�ύ����...");
			
			
			 * tr.commit();
			 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			 * ��־
			 * tr.rollback();
			 
		}
	}*/
}
