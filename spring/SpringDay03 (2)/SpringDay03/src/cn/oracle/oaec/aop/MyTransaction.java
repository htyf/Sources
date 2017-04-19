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
@Aspect//等同于<aop:aspect ref="myTransaction"></aop:aspect>
public class MyTransaction {
//	private Session session;
	private Connection con;
	//等同于<aop:around method="transaction"  pointcut="execution( * *..*.*ServiceImpl.*(..))"/>
	@Before(value="execution( * *..*.*ServiceImpl.*(..))")
	public void begingTransaction(){
		System.out.println("开启事务...");
		/*try {
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@AfterReturning(value="execution( * *..*.*ServiceImpl.*(..))")
	public void commitTransaction(){
		System.out.println("提交事务...");
		/*try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@AfterThrowing(value="execution( * *..*.*ServiceImpl.*(..))")
	public void rollbackTransaction(){
		System.out.println("回滚事务...");
		/*try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@After(value="execution( * *..*.*ServiceImpl.*(..))")
	public void doFinally(){
		System.out.println("关闭资源...");
		
	}
	
	/*public void transaction(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("开启事务...");
			
			 * Session s=hiernate.getCurrentSession();
			 * Transaction tr=s.begingTransaction();
			 
			//就等同于调用cn.oracle.oaec.service.impl.UserServiceImpl.save();
			
			joinPoint.proceed();
			System.out.println("提交事务...");
			
			
			 * tr.commit();
			 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			 * 日志
			 * tr.rollback();
			 
		}
	}*/
}
