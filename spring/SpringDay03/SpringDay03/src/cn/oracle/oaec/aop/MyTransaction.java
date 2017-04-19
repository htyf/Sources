package cn.oracle.oaec.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component(value="myTransaction")
public class MyTransaction {
	
	public void begingTransaction(){
		System.out.println("开启事务...");
	}
	public void commitTransaction(){
		System.out.println("提交事务...");
	}
	public void rollbackTransaction(){
		//日志
		System.out.println("回滚事务...");
	}
	
	public void transaction(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("开启事务...");
			/*
			 * Session s=hiernate.getCurrentSession();
			 * Transaction tr=s.begingTransaction();
			 */
			//就等同于调用cn.oracle.oaec.service.impl.UserServiceImpl.save();
			
			joinPoint.proceed();
			System.out.println("提交事务...");
			
			/*
			 * tr.commit();
			 */
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*
			 * 日志
			 * tr.rollback();
			 */
		}
	}
}
